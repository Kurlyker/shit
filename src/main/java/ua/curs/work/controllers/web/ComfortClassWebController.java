package ua.curs.work.controllers.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.curs.work.entities.ComfortClass;
import ua.curs.work.form.ComfortClassForm;
import ua.curs.work.services.comfortClass.impls.ComfortClassServiceImpl;


@Controller
@RequestMapping("/web/comfortClass/")
public class ComfortClassWebController {

    private final ComfortClassServiceImpl service;

    public ComfortClassWebController(ComfortClassServiceImpl service) {
        this.service = service;
    }


    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("comfortClases", service.getAll());
        return "comfortClassList"; }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("comfortClases", service.getAll());
        return "redirect:/web/comfortClass/list";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        ComfortClass comfortClass = service.get(id);
        ComfortClassForm comfortClassForm = new ComfortClassForm();
        comfortClassForm.setComfortClass(comfortClass.getComfortClass());
        comfortClassForm.setDescription(comfortClass.getDescription());
        model.addAttribute("comfortClassForm", comfortClassForm);
        return "comfortClassAdd";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                              @ModelAttribute("comfortClassForm") ComfortClassForm comfortClassForm,
                              @PathVariable("id") String id){

        ComfortClass comfortClass = new ComfortClass();
        comfortClass.setId(comfortClassForm.getId());
        comfortClass.setComfortClass(comfortClassForm.getComfortClass());
        comfortClass.setDescription(comfortClassForm.getDescription());
        service.edit(comfortClass);
        return "redirect:/web/comfortClass/list";
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        ComfortClassForm comfortClassForm = new ComfortClassForm();
        model.addAttribute("comfortClassForm", comfortClassForm);
        return "comfortClassAdd";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("comfortClassForm") ComfortClassForm comfortClassForm){
        ComfortClass comfortClass = new ComfortClass();
        comfortClass.setComfortClass(comfortClassForm.getComfortClass());
        comfortClass.setDescription(comfortClassForm.getDescription());
        service.save(comfortClass);
        model.addAttribute("comfortClases", service.save(comfortClass));
        return "redirect:/web/comfortClass/list";
    }

}
