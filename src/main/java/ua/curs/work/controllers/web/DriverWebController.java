package ua.curs.work.controllers.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.curs.work.entities.Driver;
import ua.curs.work.form.DriverForm;
import ua.curs.work.services.driver.impls.DriverServiceImpl;

@Controller
@RequestMapping("/web/driver/")
public class DriverWebController {

    private final DriverServiceImpl service;

    public DriverWebController(DriverServiceImpl service) {
        this.service = service;
    }


    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("drivers", service.getAll());

        return "driverList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("drivers", service.getAll());
        return "redirect:/web/driver/list";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Driver driver = service.get(id);
        DriverForm driverForm = new DriverForm();
        driverForm.setName(driver.getName());
        driverForm.setSurname(driver.getSurname());
        driverForm.setByFather(driver.getByFather());
        driverForm.setExperience(driver.getExperience());
        model.addAttribute("driverForm", driverForm);
        return "driverAdd";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("driverForm") DriverForm driverForm,
                       @PathVariable("id") String id) {

        Driver driver = new Driver();
        driver.setId(driverForm.getId());
        driver.setName(driverForm.getName());
        driver.setSurname(driverForm.getSurname());
        driver.setByFather(driverForm.getByFather());
        driver.setExperience(driverForm.getExperience());
        service.edit(driver);
        return "redirect:/web/driver/list";
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        DriverForm driverForm = new DriverForm();
        model.addAttribute("driverForm", driverForm);
        return "driverAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("driverForm") DriverForm driverForm) {
        Driver driver = new Driver();
        driver.setName(driverForm.getName());
        driver.setSurname(driverForm.getSurname());
        driver.setByFather(driverForm.getByFather());
        driver.setExperience(driverForm.getExperience());
        service.save(driver);
        model.addAttribute("drivers", service.save(driver));
        return "redirect:/web/driver/list";
    }


}