package com.example.demo.student.calc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calc")
public class CalcController {
    @GetMapping("/action")
    public String hello(@RequestParam(value = "a",required = false) String a,
                        @RequestParam(value = "b",required = false) String b,
                        @RequestParam(value = "action",required = false) String action,
                        Model model)
    {
        Double res=null;
        switch (action){
            case "a":
                res= Double.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
            case "s":
                res= Double.valueOf(Integer.parseInt(a) - Integer.parseInt(b));
            case "m":
                res= Double.valueOf(Integer.parseInt(a) * Integer.parseInt(b));
            case "d":
                res= Double.valueOf(Integer.parseInt(a) / Integer.parseInt(b));
            default:
                res=Double.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
        }
        System.out.println(a+" "+action+" "+b+" = "+res);
        model.addAttribute("result","result: " + res);
        return "index";
    }
}
