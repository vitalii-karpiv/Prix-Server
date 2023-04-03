package com.vka.prix.api.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class BaseDtoOut {

  private Map<String, Object> errorMap = new HashMap<>();

}
