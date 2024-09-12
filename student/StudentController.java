package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Controller
@RequestMapping(path = "/controller")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService=studentService;
    }

    @GetMapping ("/students")
    @ResponseBody
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/index")
    public String hello(@RequestParam(value = "name",required = false) String name,
                        @RequestParam(value = "surname",required = false) String surname,
                        Model model)
    {
        model.addAttribute("name",name);
        model.addAttribute("surname",surname);
        return "index";
    }

}
