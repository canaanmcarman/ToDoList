package com.example.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<ToDo> toDoList = new ArrayList<>();

    @GetMapping("/toDoForm")
    public String addItem(Model model) {
        model.addAttribute("toDo", new ToDo());
        return "todoform";
    }

    @PostMapping("/displayList")
    public String displayList(@Valid ToDo toDo, BindingResult result) {
        if (result.hasErrors()) {
            return "todoform";
        } else {
            toDoList.add(toDo);
            return "displaylist";
        }
    }
    @RequestMapping("/listAll")
    public String listAll(Model model) {
        model.addAttribute("toDoList", toDoList);
        return "listall";
    }
    @RequestMapping("/listItem")
    public String listItem() {
        return "listitem";

    }
}
