package com.point_map.road_data.controllers;

import com.point_map.road_data.models.Role;
import com.point_map.road_data.models.User;
import com.point_map.road_data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        System.out.println("оыповповиоипвоа");
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        System.out.println("bfjhsbfjs");
        User userFromDb = userRepository.findByUsername(user.getUsername());
        System.out.println("4535673");
        if (userFromDb != null) {
            model.addAttribute("fffff", "fnjkbf");
            return "registration";
        }

        user.setHui(true);
        user.setRoles(Collections.singleton(Role.WORKER));
        userRepository.save(user);

        return "redirect:/login";
    }
}
