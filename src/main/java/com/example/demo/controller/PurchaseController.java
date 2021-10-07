package com.example.demo.controller;

import com.example.demo.dto.PurchaseDto;
import com.example.demo.exception.UnauthenticatedException;
import com.example.demo.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/purchases")
@RequiredArgsConstructor
public class PurchaseController {
  private final PurchaseService service;

  @GetMapping
  public List<PurchaseDto> getAll() throws InterruptedException {
    Thread.sleep(5000);
    return service.getAll();
  }

  @PostMapping
  public PurchaseDto save(@RequestBody PurchaseDto dto) throws InterruptedException {
    Thread.sleep(5000);
    return service.save(dto);
  }
}
