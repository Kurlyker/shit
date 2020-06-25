package ua.curs.work.controllers.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.curs.work.entities.*;
import ua.curs.work.form.BusForm;
import ua.curs.work.services.bus.impls.BusServiceImpl;
import ua.curs.work.services.comfortClass.impls.ComfortClassServiceImpl;
import ua.curs.work.services.driver.impls.DriverServiceImpl;
import ua.curs.work.services.overallLength.impls.OverallLengthServiceImpl;
import ua.curs.work.services.passangerClass.impls.PassangerClassServiceImpl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/bus/")
public class BusWebController {

    @Autowired
    DriverServiceImpl driverService;

    private final BusServiceImpl service;

    private final ComfortClassServiceImpl comfortClassService;

    private final PassangerClassServiceImpl passangerClassService;

    private final OverallLengthServiceImpl overallLengthService;

    public BusWebController(BusServiceImpl service, ComfortClassServiceImpl comfortClassService, PassangerClassServiceImpl passangerClassService, OverallLengthServiceImpl overallLengthService) {
        this.service = service;
        this.comfortClassService = comfortClassService;
        this.passangerClassService = passangerClassService;
        this.overallLengthService = overallLengthService;
    }


    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("buses", service.getAll());

        return "busList"; }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("buses", service.getAll());
        return "redirect:/web/bus/list";
    }

    @RequestMapping("/list/{id}")
    String findById(Model model,
                  @PathVariable("id") String id){
        Bus bus = service.get(id);
        model.addAttribute("buses", bus);

        return "redirect:/web/bus/list";
    }

/*

    @GetMapping("/create")
    public String createBusForm(Bus bus){
        return "busAdd";
    }

    @PostMapping("/create")
    public String create(Bus bus){
        service.save(bus);
        return "redirect:/busList";
    }

*/

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Bus bus = service.get(id);
        BusForm busForm = new BusForm();
        busForm.setNumber(bus.getNumber());
        busForm.setModel(bus.getModel());
        busForm.setColor(bus.getColor());
        List<Driver> driver = driverService.getAll();
        Map<String, String> drivers = driverService.getAll().stream()
                .collect(Collectors.toMap(Driver::getId, Driver::getSurname));
        model.addAttribute("drivers", drivers);
        busForm.setDriver(bus.getDriver());
        busForm.setNumberOfSeat(bus.getNumberOfSeat());

        model.addAttribute("busForm", busForm);
        return "busAdd";
    }



    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                              @ModelAttribute("busForm") BusForm busForm,
                              @PathVariable("id") String id){

        Bus bus = new Bus();
        bus.setId(busForm.getId());
        bus.setNumber(busForm.getNumber().toUpperCase());
        bus.setModel(busForm.getModel());
        bus.setColor(busForm.getColor().toLowerCase());
        bus.setDriver(busForm.getDriver());
        bus.setNumberOfSeat(busForm.getNumberOfSeat());
        service.edit(bus);
        return "redirect:/web/bus/list";
    }
/*
    @GetMapping("/uppdate/{id}")
    public String uppdate(@PathVariable("id")String id, Model model) {
        Bus bus = service.get(id);
        model.addAttribute("bus", bus);
        return "busEdit";

    }
    @PostMapping("/uppdate")
    public String uppdate(Bus bus){
        service.edit(bus);
        return "redirect:/web/bus/list";
    }


 */

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        BusForm busForm = new BusForm();

        List<Driver> driver = driverService.getAll();
        Map<String, String> drivers = driverService.getAll().stream()
                .collect(Collectors.toMap(Driver::getId, Driver::getSurname));
        model.addAttribute("drivers", drivers);

        List<ComfortClass> comfortClass = comfortClassService.getAll();
        Map<String, String> comfortClases = comfortClassService.getAll().stream()
                .collect(Collectors.toMap(ComfortClass::getId, ComfortClass::getComfortClass));
        model.addAttribute("comfortClases", comfortClases);

        List<PassangerClass> passangerClass = passangerClassService.getAll();
        Map<String, String> passangerClasses = passangerClassService.getAll().stream()
                .collect(Collectors.toMap(PassangerClass::getId, PassangerClass::getPassangerClass));
        model.addAttribute("passangerClasses", passangerClasses);

        List<OverallLength> overallLength = overallLengthService.getAll();
        Map<String, String> overallLengths = overallLengthService.getAll().stream()
                .collect(Collectors.toMap(OverallLength::getId, OverallLength::getName));
        model.addAttribute("overallLengths", overallLengths);

        model.addAttribute("busForm", busForm);
        return "busAdd";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("busForm") BusForm busForm){
        Bus bus = new Bus();
        bus.setNumber(busForm.getNumber().toUpperCase());
        bus.setModel(busForm.getModel());
        bus.setColor(busForm.getColor().toLowerCase());
        bus.setDriver(busForm.getDriver());
        bus.setNumberOfSeat(busForm.getNumberOfSeat());
        bus.setComfortClass(busForm.getComfortClass());
        bus.setPassangerClass(busForm.getPassangerClass());
        bus.setOverallLength(busForm.getOverallLength());
        service.save(bus);
        model.addAttribute("buses", service.save(bus));
        return "redirect:/web/bus/list";
    }


}
