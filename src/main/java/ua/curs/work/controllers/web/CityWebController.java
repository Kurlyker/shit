package ua.curs.work.controllers.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.curs.work.entities.City;
import ua.curs.work.form.CityForm;
import ua.curs.work.services.city.impls.CityServiceImpl;


@Controller
@RequestMapping("/web/city/")
public class CityWebController {

    private final CityServiceImpl service;

    public CityWebController(CityServiceImpl service) {
        this.service = service;
    }


    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("cities", service.getAll());
        return "cityList"; }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("cities", service.getAll());
        return "redirect:/web/city/list";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        City city = service.get(id);
        CityForm cityForm = new CityForm();
        cityForm.setName(city.getName());
        model.addAttribute("cityForm", cityForm);
        return "cityAdd";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                              @ModelAttribute("cityForm") CityForm cityForm,
                              @PathVariable("id") String id){

        City city = new City();
        city.setId(cityForm.getId());
        city.setName(cityForm.getName());
        service.edit(city);
        return "redirect:/web/city/list";
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        CityForm cityForm = new CityForm();
        model.addAttribute("cityForm", cityForm);
        return "cityAdd";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("cityForm") CityForm cityForm){
        City city = new City();
        city.setName(cityForm.getName());
        service.save(city);
        model.addAttribute("cities", service.save(city));
        return "redirect:/web/city/list";
    }

}
