package org.launchcode.controllers;

import org.launchcode.models.Menu;
import org.launchcode.models.data.CategoryDao;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.data.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private CheeseDao cheeseDao;

    @Autowired
    private MenuDao menuDao;

    // Request path: /menu
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("Menus", menuDao.findAll());
        model.addAttribute("title", "Menus" );
        return "menu/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(Model model){

        model.addAttribute(new Menu());
        model.addAttribute("title", "Add New Menu");
        return "menu/add";
    }
}
