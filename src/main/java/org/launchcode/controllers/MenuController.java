package org.launchcode.controllers;

import org.launchcode.models.Cheese;
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
            model.addAttribute("title", "Add New Menu");
            return "menu/add";
        }
        menuDao.save(menu);
        return "redirect:view/" + menu.getId();
    }

    @RequestMapping(value="view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @Valid @PathVariable int menuId){
        Menu theMenu = menuDao.findOne(menuId);
        model.addAttribute("menu", theMenu);
        model.addAttribute("cheeses", theMenu.getCheeses());
        return "menu/view";
    }

    @RequestMapping(value="add-item/{menuId}", method = RequestMethod.GET)
    public String addItem(Model model, @Valid @PathVariable int menuId){
        Menu theMenu = menuDao.findOne(menuId);
        AddMenuItemForm form = new AddMenuItemForm(theMenu, cheeseDao.findAll());

        model.addAttribute("form", form);
        model.addAttribute("title", "Add item to menu: " + theMenu.getName());
        System.out.println("get request for add-item{id}");
        return "menu/add-item";
    }

    @RequestMapping(value="add-item", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid AddMenuItemForm form, Errors errors){

        if(errors.hasErrors()){
            System.out.println("This has errors. Fix it Tammy");
            model.addAttribute("form", form);
            return "menu/add-item";
        }
        System.out.println("I think it worked");
        Cheese theCheese = cheeseDao.findOne(form.getCheeseId());
        System.out.println("we found the cheese");
        Menu theMenu = menuDao.findOne(form.getMenuId());
        System.out.println("we found the menu");
        theMenu.addItem(theCheese);
        menuDao.save(theMenu);
        System.out.println("The menu was saved");

        return "redirect:/menu/view/"+ theMenu.getId();
    }
}
