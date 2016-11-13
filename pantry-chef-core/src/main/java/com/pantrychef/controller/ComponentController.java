package com.pantrychef.controller;

import com.pantrychef.model.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/components")
public class ComponentController {

    public List<Component> get(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "limit", required = false, defaultValue = "50") Integer limit,
            @RequestParam(name = "offset", required = false, defaultValue = "1") Integer offset) {

        List<Component> components = null;

        return components;
    }
}
