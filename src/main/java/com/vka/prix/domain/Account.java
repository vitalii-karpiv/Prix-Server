package com.vka.prix.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {

  @Id
  @GeneratedValue
  private Long id;
  private Double balance;
  private String color;
  private String currency;
  private String name;
  private String type;

}
