package com.aop.article.example.dto.identity;

import lombok.Data;

@Data
public class Identity<Key> {
  private Key recordId;
}
