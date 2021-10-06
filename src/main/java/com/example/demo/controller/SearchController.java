package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/search")
public class SearchController {
  private List<String> suggestions = List.of("ANGULAR", "JS", "RXJS", "JAVA", "JAVASCRIPT");
  private int count = 1;

  // ?text=...
  @GetMapping
  public List<String> suggest(@RequestParam String text) throws InterruptedException {
    Thread.sleep(5000);
    final String textToSearch = text.toUpperCase();
    if (textToSearch.startsWith("XXX")) {
      throw new RuntimeException("Bad request");
    }

    return suggestions.stream()
      .filter(o -> o.contains(textToSearch))
      .collect(Collectors.toList());
  }
}
