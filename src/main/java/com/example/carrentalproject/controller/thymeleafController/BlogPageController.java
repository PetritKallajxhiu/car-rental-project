package com.example.carrentalproject.controller.thymeleafController;

import com.example.carrentalproject.service.BlogServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogPageController {
    private BlogServices blogServices;

    public BlogPageController(BlogServices blogServices) {
        this.blogServices = blogServices;
    }

    @RequestMapping("/allBlogs")
    public String blogs(final ModelMap modelMap, @RequestParam(value = "b", required = false) String b) {
        var blogs = b != null && b != "" ? this.blogServices.search(b) : this.blogServices.findAll();
        modelMap.addAttribute("blogs", blogs);
        return "blog";
    }

    @GetMapping("/blog/details/{id}")
    public String details(@PathVariable int id, final ModelMap modelMap) {
        var blog = blogServices.findAllById(id).orElseThrow(() -> new RuntimeException("Invalid id"));
        modelMap.addAttribute("blog", blog);

        var blogs = this.blogServices.findAll();
        modelMap.addAttribute("blogs", blogs);
        return "blog_details";
    }
}
