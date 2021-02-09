package com.portfolio.springboot.validatingforminput;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/resultsValidation").setViewName("resultsValidation");
    }

    @GetMapping("/formValidation")
    public String showForm(PersonForm personForm) {
        return "formValidation";
    }

    @PostMapping("/formValidation")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "formValidation";
        }

        return "redirect:/resultsValidation";
    }
}