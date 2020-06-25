package ua.curs.work.controllers.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.curs.work.entities.PassangerClass;
import ua.curs.work.form.PassangerClassForm;
import ua.curs.work.services.passangerClass.impls.PassangerClassServiceImpl;


@Controller
@RequestMapping("/web/passangerClass/")
public class PassangerClassWebController {

    private final PassangerClassServiceImpl service;

    public PassangerClassWebController(PassangerClassServiceImpl service) {
        this.service = service;
    }


    @RequestMapping("/list")
    String getAll(Model model){
        model.addAttribute("passangerClases", service.getAll());
        return "passangerClassList"; }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        service.delete(id);
        model.addAttribute("passangerClases", service.getAll());
        return "redirect:/web/passangerClass/list";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        PassangerClass passangerClass = service.get(id);
        PassangerClassForm passangerClassForm = new PassangerClassForm();
        passangerClassForm.setPassangerClass(passangerClass.getPassangerClass());
        passangerClassForm.setDescription(passangerClass.getDescription());
        model.addAttribute("passangerClassForm", passangerClassForm);
        return "passangerClassAdd";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                              @ModelAttribute("passangerClassForm") PassangerClassForm passangerClassForm,
                              @PathVariable("id") String id){

        PassangerClass passangerClass = new PassangerClass();
        passangerClass.setId(passangerClassForm.getId());
        passangerClass.setPassangerClass(passangerClassForm.getPassangerClass());
        passangerClass.setDescription(passangerClassForm.getDescription());
        service.edit(passangerClass);
        return "redirect:/web/passangerClass/list";
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model){
        PassangerClassForm passangerClassForm = new PassangerClassForm();
        model.addAttribute("passangerClassForm", passangerClassForm);
        return "passangerClassAdd";
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("passangerClassForm") PassangerClassForm passangerClassForm){
        PassangerClass passangerClass = new PassangerClass();
        passangerClass.setPassangerClass(passangerClassForm.getPassangerClass());
        passangerClass.setDescription(passangerClassForm.getDescription());
        service.save(passangerClass);
        model.addAttribute("busClases", service.save(passangerClass));
        return "redirect:/web/passangerClass/list";
    }

}
