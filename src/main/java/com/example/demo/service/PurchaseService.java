package com.example.demo.service;

import com.example.demo.dto.PurchaseDto;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService implements InitializingBean {
  private List<PurchaseDto> items = new ArrayList<>();
  private long nextId = 1;


  public List<PurchaseDto> getAll() {
    return items;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    items.add(new PurchaseDto(nextId++, "first", 10_000));
  }

  public PurchaseDto save(PurchaseDto dto) {
    if (dto.getId() == 0) {
      dto.setId(nextId++);
      items.add(dto);
      return dto;
    }

    items = items.stream().map(o -> o.getId() != dto.getId() ? o : dto).collect(Collectors.toList());
    return dto;
  }
}
