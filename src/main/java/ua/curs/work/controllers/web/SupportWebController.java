package ua.curs.work.controllers.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.curs.work.entities.Support;
import ua.curs.work.form.SupportForm;
import ua.curs.work.services.city.impls.CityServiceImpl;
import ua.curs.work.services.support.impls.SupportServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;


@Controller
public class SupportWebController {


    @Autowired
    private MailSender mailSender;

    private final SupportServiceImpl service;

    private final CityServiceImpl cityService;

    public SupportWebController(SupportServiceImpl service, CityServiceImpl cityService) {
        this.service = service;
        this.cityService = cityService;
    }


    @RequestMapping("/support/listAll")
    String getAll(Model model){
        model.addAttribute("supports", service.getAll());
        return "qestionList"; }

    @RequestMapping("/support/list")
    String getActive(Model model){
        model.addAttribute("supports", service.getActive(true));
        return "qestionList"; }


    @RequestMapping(value = "/help/create", method = RequestMethod.GET)
    String create(Model model){
        SupportForm supportForm = new SupportForm();
        model.addAttribute("supportForm", supportForm);
        return "question";
    }
    @RequestMapping(value = "/help/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("supportForm") SupportForm supportForm,
                  HttpServletRequest request) throws ServletException, IOException {
        Support support = new Support();
        LocalDateTime timeNow = LocalDateTime.now();
        support.setEmail(request.getUserPrincipal().getName());
        support.setDateSend(timeNow);
        support.setText(supportForm.getText());
        support.setActive(true);
        service.save(support);
        model.addAttribute("cities", cityService.getAll());
        return "redirect:/dashboard";
    }


    @RequestMapping(value = "/support/answer/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Support support = service.get(id);
        SupportForm supportForm = new SupportForm();
        supportForm.setId(support.getId());
        supportForm.setEmail(support.getEmail());
        supportForm.setDateSend(support.getDateSend());
        supportForm.setText(support.getText());
        model.addAttribute("supportForm", supportForm);
        return "answer";
    }


    @RequestMapping(value = "/support/answer/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("supportForm") SupportForm supportForm,
                       @PathVariable("id") String id) {
        Support support = new Support();
        support.setId(supportForm.getId());
        support.setEmail(supportForm.getEmail());
        support.setDateSend(supportForm.getDateSend());
        support.setText(supportForm.getText());
        support.setAnswer(supportForm.getAnswer());
        support.setActive(false);
        send(support.getEmail(), support.getText(), supportForm.getAnswer());
        service.edit(support);
        return "redirect:/support/list";
    }

    public void send(String to, String text, String answer){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom("h9people@gmail.com");
        msg.setSubject("Відповідь підтримки");
        msg.setText("Доброго дня.\nВаше питання: \n"+ text +"\n \n" + "Відповідь : \n"+answer+"\n\nЗ повагою H9 Peole.");
        mailSender.send(msg);
    }

}
