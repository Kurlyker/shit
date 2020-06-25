package ua.curs.work.controllers.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.curs.work.entities.Bus;
import ua.curs.work.entities.City;
import ua.curs.work.entities.Route;
import ua.curs.work.form.RouteForm;
import ua.curs.work.repositoryes.RouteRepository;
import ua.curs.work.services.bus.impls.BusServiceImpl;
import ua.curs.work.services.city.impls.CityServiceImpl;
import ua.curs.work.services.route.impls.RouteServiceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BookingWebController {


    private final CityServiceImpl service;

    private final RouteServiceImpl routeService;

    private final BusServiceImpl busService;

    private final RouteRepository routeRepository;

    public ArrayList<String> save = new ArrayList<>();

    public ArrayList<City> saveCity = new ArrayList<City>();

    public String message="";

    public BookingWebController(CityServiceImpl service, RouteServiceImpl routeService, BusServiceImpl busService, RouteRepository routeRepository) {
        this.service = service;
        this.routeService = routeService;
        this.busService = busService;
        this.routeRepository = routeRepository;
    }

    @GetMapping("/web/route/list")
    String list(Model model){
        model.addAttribute("routes", routeService.getAll());
        return "routeList";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    String create(Model model){
        RouteForm routeForm = new RouteForm();
        List<City> city = service.getAll();
        Map<String, String> cities = service.getAll().stream()
                .collect(Collectors.toMap(City::getId, City::getName));
        model.addAttribute("cities", cities);
        model.addAttribute("routeForm", routeForm);
        model.addAttribute("message",message);
        message="";
        return "dashboard";
    }


    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("routeForm") RouteForm routeForm){
        City a= routeForm.getFromCity();
        City b= routeForm.getToCity();
        String c= routeForm.getDateDeparture();
        saveCity.add(a);
        saveCity.add(b);
        save.add(c);
        message="";
        return "redirect:/find";
    }



    @GetMapping("/find")
    String find(Model model) {
        City saves = saveCity.get(0);
        City saves1 = saveCity.get(1);
        String saves2 = save.get(0);
        model.addAttribute("routes", routeService.getRoute(saves, saves1, saves2,"true"));

        if (routeService.getRoute(saves, saves1, saves2,"true").toString() == "[]") {
            save.clear();
            saveCity.clear();
            message="За вказаним пошуком рейсу не знайдено!";
            return "redirect:/dashboard";
        }
        else {
            save.clear();
            saveCity.clear();
            return "dashboardFind";}
    }






    @RequestMapping(value = "/web/route/create", method = RequestMethod.GET)
    String createRoute(Model model){
        RouteForm routeForm = new RouteForm();

        List<City> city = service.getAll();
        Map<String, String> cities = service.getAll().stream()
                .collect(Collectors.toMap(City::getId, City::getName));
        model.addAttribute("cities", cities);

        List<Bus> bus = busService.getAll();
        Map<String, String> buses = busService.getAll().stream()
                .collect(Collectors.toMap(Bus::getId, Bus::getNumber));
        model.addAttribute("buses", buses);

        model.addAttribute("message", message);


        model.addAttribute("routeForm", routeForm);
        return "routeAdd";
    }



    @RequestMapping(value = "/web/route/create", method = RequestMethod.POST)
    String createRoute(Model model, @ModelAttribute("routeForm") RouteForm routeForm){
        Route route = new Route();
        route.setFromCity(routeForm.getFromCity());
        route.setToCity(routeForm.getToCity());
        route.setBus(routeForm.getBus());
        route.setDateDeparture(routeForm.getDateDeparture());
        route.setTimeDeparture(routeForm.getTimeDeparture());
        route.setDateOfArrival(routeForm.getDateOfArrival());
        route.setTimeOfArrival(routeForm.getTimeOfArrival());
        route.setPrice(routeForm.getPrice());
        route.setSeats(routeForm.getBus().getNumberOfSeat());
        route.setActive("true");

        LocalDate dD = LocalDate.parse(route.getDateDeparture());
        LocalDate dA = LocalDate.parse(route.getDateOfArrival());
        LocalTime tD = LocalTime.parse(route.getTimeDeparture());
        LocalTime tA = LocalTime.parse(route.getTimeOfArrival());
        message="";

        if (dA.isBefore(dD)){
            System.out.println("Дата відправки повинна бути раніше ніж дата прибуття!");
            message="Дата відправки повинна бути раніше ніж дата прибуття!";
            return "redirect:/web/route/create";
        }
        else {
            if (dA.isEqual(dD)){
                if (tA.isBefore(tD)){
                    System.out.println("Час відправки повинен бути раніше ніж час прибуття!");
                    message="Час відправки повинен бути раніше ніж час прибуття!";
                    return "redirect:/web/route/create";
                }
                else{
                    routeService.save(route);
                    model.addAttribute("routes", routeService.save(route));
                    return "redirect:/web/route/list";
                }
            }
            else {
                routeService.save(route);
                model.addAttribute("routes", routeService.save(route));
                return "redirect:/web/route/list";
            }
        }

    }

    @RequestMapping("web/route/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id){
        routeService.delete(id);
        model.addAttribute("routes", routeService.getAll());
        return "redirect:/web/route/list";
    }

    @RequestMapping(value = "/web/route/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id){
        Route route = routeService.get(id);
        RouteForm routeForm = new RouteForm();
        List<City> city = service.getAll();
        Map<String, String> cities = service.getAll().stream()
                .collect(Collectors.toMap(City::getId, City::getName));
        model.addAttribute("cities", cities);
        routeForm.setFromCity(route.getFromCity());
        routeForm.setToCity(route.getToCity());
        List<Bus> bus = busService.getAll();
        Map<String, String> buses = busService.getAll().stream()
                .collect(Collectors.toMap(Bus::getId, Bus::getNumber));
        model.addAttribute("buses", buses);
        routeForm.setDateDeparture(route.getDateDeparture());
        routeForm.setTimeDeparture(route.getTimeDeparture());
        routeForm.setDateOfArrival(route.getDateOfArrival());
        routeForm.setTimeOfArrival(route.getTimeOfArrival());
        routeForm.setPrice(route.getPrice());
        routeForm.setSeats(route.getSeats());
        model.addAttribute("message",message);
        message="";
        model.addAttribute("routeForm", routeForm);
        return "routeAdd";
    }



    @RequestMapping(value = "/web/route/edit/{id}", method = RequestMethod.POST)
    public String edit(Model model,
                       @ModelAttribute("routeForm") RouteForm routeForm,
                       @PathVariable("id") String id){
        Route route = new Route();
        route.setId(routeForm.getId());
        route.setFromCity(routeForm.getFromCity());
        route.setToCity(routeForm.getToCity());
        route.setBus(routeForm.getBus());
        route.setDateDeparture(routeForm.getDateDeparture());
        route.setTimeDeparture(routeForm.getTimeDeparture());
        route.setDateOfArrival(routeForm.getDateOfArrival());
        route.setTimeOfArrival(routeForm.getTimeOfArrival());
        route.setPrice(routeForm.getPrice());
        route.setSeats(routeForm.getSeats());


        LocalDate dD = LocalDate.parse(route.getDateDeparture());
        LocalDate dA = LocalDate.parse(route.getDateOfArrival());
        LocalTime tD = LocalTime.parse(route.getTimeDeparture());
        LocalTime tA = LocalTime.parse(route.getTimeOfArrival());
        message="";

        if (dA.isBefore(dD)){
            System.out.println("Дата відправки повинна бути раніше ніж дата прибуття!");
            message="Дата відправки повинна бути раніше ніж дата прибуття!";
            String w= "redirect:/web/route/edit/"+route.getId();
            return w;
        }
        else {
            if (dA.isEqual(dD)){
                if (tA.isBefore(tD)){
                    System.out.println("Час відправки повинен бути раніше ніж час прибуття!");
                    message="Час відправки повинен бути раніше ніж час прибуття!";
                    String w= "redirect:/web/route/edit/"+route.getId();
                    return w;
                }
                else{
                    routeService.edit(route);
                    model.addAttribute("routes", routeService.save(route));
                    return "redirect:/web/route/list";
                }
            }
            else {
                routeService.edit(route);
                model.addAttribute("routes", routeService.save(route));
                return "redirect:/web/route/list";
            }
        }


    }




}
