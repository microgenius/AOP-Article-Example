package com.aop.article.example.dto.customer;

import com.aop.article.example.dto.identity.Identity;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer extends Identity<Long> {
  private String name;
  private String surname;
  private LocalDate birthDate;
}
