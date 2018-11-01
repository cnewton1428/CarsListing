package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    CategoryRepository categoryRepository;
    @RequestMapping("/")
    public String getHomepage() {
        return "index";
    }

    @GetMapping("/addCategory")
    public String getCategoryForm(Model model){
        model.addAttribute("category", new Category());
        return "categoryform";

}
@PostMapping("/addCategory") //taken from th:action from categoryForm
    public String addCategory(@ModelAttribute("category")Category category){ //write category1 or category; a local declaration so saved in the bracket
    categoryRepository.save(category);
    return "categorylist";
}
//after user clicks submit

@RequestMapping("categorylist")
    public String getCategoryList(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist";
}
}
