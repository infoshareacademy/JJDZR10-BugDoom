package com.infoshareacademy.pl.controller;

import com.infoshareacademy.pl.model.Location;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.ArrayList;

import static org.springframework.http.HttpMethod.*;

@Controller
public class MapController {


    @GetMapping("/map")
   public String getMap(Model model){
        List<Location> controlPointList = new ArrayList<>();
        controlPointList.add(new Location(54.35, 18.65, "start"));
        controlPointList.add(new Location(54.35, 18.59, "meta"));
        model.addAttribute("controlPointList", controlPointList);
        return "map";
    }

}
