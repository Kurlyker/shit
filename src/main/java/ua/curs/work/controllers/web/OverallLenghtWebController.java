package ua.curs.work.controllers.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.curs.work.entities.OverallLength;
import ua.curs.work.form.OverallLengthForm;
import ua.curs.work.services.overallLength.impls.OverallLengthServiceImpl;


@Controller
@RequestMapping("/web/overallLength/")
public class OverallLenghtWebController {

    private final OverallLengthServiceImpl service;

    public OverallLenghtWebController(OverallLengthServiceImpl service) {
        this.service = service;
    }


    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("overallLengths", service.getAll());
        return "overallLengthList"; }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("overallLenghts", service.getAll());
        return "redirect:/web/overallLength/list";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        OverallLength overallLength = service.get(id);
        OverallLengthForm overallLengthForm = new OverallLengthForm();
        overallLengthForm.setName(overallLength.getName());
        overallLengthForm.setDescription(overallLength.getDescription());
        model.addAttribute("overallLengthForm", overallLength);
        return "overallLengthAdd";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                              @ModelAttribute("overallLengthForm") OverallLengthForm overallLengthForm,
                              @PathVariable("id") String id){

        OverallLength overallLength = new OverallLength();
        overallLength.setId(overallLengthForm.getId());
        overallLength.setName(overallLengthForm.getName());
        overallLength.setDescription(overallLengthForm.getDescription());
        service.edit(overallLength);
        return "redirect:/web/overallLength/list";
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        OverallLengthForm overallLengthForm = new OverallLengthForm();
        model.addAttribute("overallLengthForm", overallLengthForm);
        return "overallLengthAdd";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("overallLengthForm") OverallLengthForm overallLengthForm){
        OverallLength overallLength = new OverallLength();
        overallLength.setName(overallLengthForm.getName());
        overallLength.setDescription(overallLengthForm.getDescription());
        service.save(overallLength);
        model.addAttribute("overallLengths", service.save(overallLength));
        return "redirect:/web/overallLength/list";
    }

}
