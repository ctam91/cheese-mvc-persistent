package org.launchcode.controllers;

import org.launchcode.models.Menu;
import org.launchcode.models.data.CategoryDao;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.data.MenuDao;
import org.launchcode.models.forms.AddMenuItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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

        model.addAttribute("menus", menuDao.findAll());
        model.addAttribute("title", "Menus" );
        return "menu/index";
    }

    @RequestMapping(value="add", method = RequestMethod.GET)
    public String add(Model model){

        model.addAttribute(new Menu());
        model.addAttribute("title", "Add New Menu");
        return "menu/add";
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddForm(Model model, @ModelAttribute @Valid Menu menu, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute(new Menu());
            model.addAttribute("title", "Add New Menu");
            return "menu/add";
        }
        menuDao.save(menu);
        return "redirect:";
    }

    @RequestMapping(value="view/{id}", method = RequestMethod.GET)
    public String viewMenu(Model model, @Valid @PathVariable int id){
        Menu theMenu = menuDao.findOne(id);
        model.addAttribute("menu", theMenu);
        return "menu/view";
    }

    @RequestMapping(value="add-item/{id}", method = RequestMethod.GET)
    public String addItem(Model model, @Valid @PathVariable int id){
        Menu theMenu = menuDao.findOne(id);

        model.addAttribute("cheeses", theMenu.getCheeses());
        model.addAttribute(new AddMenuItemForm());
        model.addAttribute("title", "Add item to menu: " + theMenu);
        return "menu/add-item";
    }
}
