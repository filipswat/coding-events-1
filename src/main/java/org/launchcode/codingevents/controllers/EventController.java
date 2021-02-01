package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.classes.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    private static List<Event> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", events);
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    @PostMapping("create")
    //update to take pictureURL as RequestParam if using web picture
    public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDesc) {
        String pictureURL = "/pictures/" + getRandomPicture();

        Event newEvent = new Event(eventName, eventDesc, pictureURL);

        /* option if accepting web URL for picture url
        if (!(pictureURL == "" || pictureURL.isEmpty())) {
            newEvent.setPictureURL(pictureURL);
        }*/

        events.add(newEvent);
        return "redirect:";
    }

    public String getRandomPicture() {
        File directory = new File("src/main/resources/static/pictures");
        String[] files = directory.list();
        int randomLocation = new Random().nextInt(files.length);
        return files[randomLocation];
    }
}
