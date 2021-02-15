package org.launchcode.helloSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class helloController {

    //no routing information (on GetMapping annotation) = default to root path
    //to handle requests at /hello add to GetMapping annotation
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }

    //now lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring";
    }

    //handles requests of the form /hello?name=LaunchCode (query request)
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handles requests of the form /hello/LaunchCode (path request)


    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" + //submit a request to /hello; form default method is a get request (rather than post request)
                            "<input type='text' name='name'>" +
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

}
