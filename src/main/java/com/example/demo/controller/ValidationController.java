package com.example.demo.controller;

import com.example.demo.dto.ValidationDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/validate")
public class ValidationController {
  private List<String> forbidden = List.of("JS");

  // ?text=...
  @GetMapping
  public ValidationDto validate(@RequestParam String name) throws InterruptedException {
    Thread.sleep(5000);
    final String textToSearch = name.toUpperCase();

    return new ValidationDto(forbidden.contains(textToSearch) ? "error" : "ok");
  }
}
