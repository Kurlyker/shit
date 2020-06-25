package ua.curs.work.controllers.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.curs.work.entities.Bus;
import ua.curs.work.services.bus.impls.BusServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/bus/")
public class BusApiController {

    @Autowired
    BusServiceImpl service;

    @RequestMapping("/list")
    List<Bus> getAll(){ return service.getAll(); }

    @RequestMapping("/get/{id}")
    Bus getById(@PathVariable("id") String id){
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Bus create(@RequestBody Bus bus){
        return service.save(bus);
    }

    @RequestMapping("/delete/{id}")
    public Bus delete(@PathVariable("id") String id){
        return service.delete(id);
    }

}
