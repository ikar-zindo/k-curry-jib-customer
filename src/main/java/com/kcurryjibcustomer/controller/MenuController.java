package com.kcurryjibcustomer.controller;

import com.kcurryjibcustomer.dto.ProductDto;
import com.kcurryjibcustomer.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/menu")
@SessionAttributes("editMenu")
public class MenuController {

   private final MenuService service;

   @Autowired
   public MenuController(MenuService service) {

      this.service = service;
   }

   @GetMapping
   public String getAll(Model model) {
      List<ProductDto> productsDto = service.getAvailableProducts();

      model.addAttribute("products", productsDto);

      return "/menu/list";
   }
}
