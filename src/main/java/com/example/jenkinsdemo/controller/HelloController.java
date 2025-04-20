package com.example.jenkinsdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

  @GetMapping
  public String hello() {
    return "Hello, Spring Boot!";
  }

  @GetMapping("/echo")
  public String echo(@RequestParam("message") String message) {
    return message;
  }

  @GetMapping("/greet")
  public String greet(@RequestParam("name") String name) {
    return "Hello, " + name + "!";
  }

  @GetMapping("/greet/spanish")
  public String greetSpanish(@RequestParam("name") String name) {
    return "Hola, " + name + "!";
  }

  @GetMapping("/greet/french")
  public String greetFrench(@RequestParam("name") String name) {
    return "Bonjour, " + name + "!";
  }

  @GetMapping("/greet/italian")
  public String greetItalian(@RequestParam("name") String name) {
    return "Ciao, " + name + "!";
  }

}
