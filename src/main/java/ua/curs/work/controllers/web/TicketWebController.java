package ua.curs.work.controllers.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.curs.work.entities.Route;
import ua.curs.work.entities.Ticket;
import ua.curs.work.form.TicketForm;
import ua.curs.work.services.route.impls.RouteServiceImpl;
import ua.curs.work.services.ticket.impls.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


@Controller
public class TicketWebController {


    @Autowired
    private MailSender mailSender;

    private final TicketServiceImpl service;

    private final RouteServiceImpl routeService;

    private final TicketServiceImpl ticketService;

    public TicketWebController(TicketServiceImpl service, RouteServiceImpl routeService, TicketServiceImpl ticketService) {
        this.service = service;
        this.routeService = routeService;
        this.ticketService = ticketService;
    }


    @RequestMapping("ticket/web/ticket/list")
    String getAll(Model model){
        model.addAttribute("tickets", service.getAll());
        return "ticketList";
    }


    @RequestMapping("ticket/buy/{id}")
    String delete(Model model, @ModelAttribute("ticketForm") TicketForm ticketForm,
                  @PathVariable("id") String id,
                  HttpServletRequest request) throws ServletException, IOException {
        Ticket ticket = new Ticket();
        ticket.setUser(request.getUserPrincipal().getName());
        Route route = routeService.findById(id);
        route.setSeats(route.getSeats()-1);
        if (route.getSeats()==0){route.setActive("false");}
        routeService.save(route);
        ticket.setRoute(route);
        ticket.setNumber(1);
        send(request.getUserPrincipal().getName(),
                ticket.getRoute().getId(),
                ticket.getRoute().getFromCity().getName(),  ticket.getRoute().getToCity().getName(),
                ticket.getRoute().getDateDeparture(), ticket.getRoute().getDateOfArrival(),
                ticket.getRoute().getTimeDeparture(), ticket.getRoute().getTimeOfArrival());
        service.save(ticket);
        return "redirect:/ticket/myTickets";
    }



/*
    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    String create(Model model){
        TicketForm ticketForm = new TicketForm();
        model.addAttribute("ticketForm", ticketForm);
        return "ticketBuy";
    }
    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("ticketForm") TicketForm ticketForm,
                  HttpServletRequest request) throws ServletException, IOException {
        Ticket ticket = new Ticket();
        ticket.setUser(request.getUserPrincipal().getName());

        service.save(city);
        model.addAttribute("cities", service.save(city));
        return "redirect:/web/city/list";
    }
*/

    @RequestMapping("ticket/myTickets")
    String getAllMyTickets(Model model,
                           HttpServletRequest request) throws ServletException, IOException {
        String user = request.getUserPrincipal().getName();
        List<Ticket> ticket = service.getAll();
        Collections.reverse(ticket);
        model.addAttribute("tickets", ticket);
        return "myTickets";
    }

    @RequestMapping("web/route/getTickets/{id}")
    String getTickets(Model model,
                           @PathVariable("id") String id,
                           HttpServletRequest request) throws ServletException, IOException {

        model.addAttribute("tickets", service.findByRoute(id));
        return "routeEbout";
    }




    public void send(String to, String id, String fCity, String tCity, String fDate, String tDate, String fTime, String tTime){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom("h9people@gmail.com");
        msg.setSubject("Заброньований квиток");
        msg.setText("Доброго дня.\nВами заброньований квиток:\nНомер: "+ id +
                "\nМісто посадки: "+ fCity +
                "\nМісто прибуття: "+ tCity +
                "\nДата посадки: "+ fDate + ", час посадки: "+ fTime +
                "\nДата Прибуття: "+ tDate + ", час прибуття: "+ tTime +
                "\n\nЗ повагою H9 Peole.\nДякуємо, що залишаєтесь з нами!");
        mailSender.send(msg);
    }


    @RequestMapping("web/route/getTickets/delete/{id}")
    String delete(Model model, @ModelAttribute("ticketForm") TicketForm ticketForm,
                  @PathVariable("id") String id) {
        Ticket ticket = ticketService.get(id);
        Route route = routeService.findById(ticket.getRoute().getId());
        route.setSeats(route.getSeats()+1);
        if (route.getSeats()>0){route.setActive("true");}
        routeService.save(route);
        ticketService.delete(ticket.getId());
    /*    send(request.getUserPrincipal().getName(),
                ticket.getRoute().getId(),
                ticket.getRoute().getFromCity().getName(),  ticket.getRoute().getToCity().getName(),
                ticket.getRoute().getDateDeparture(), ticket.getRoute().getDateOfArrival(),
                ticket.getRoute().getTimeDeparture(), ticket.getRoute().getTimeOfArrival());
        service.save(ticket);*/
        return "redirect:/web/route/list";
    }

}
