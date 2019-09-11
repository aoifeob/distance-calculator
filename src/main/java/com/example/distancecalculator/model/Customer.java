package com.example.distancecalculator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

  @JsonProperty("user_id")
  private int id;
  private String name;
  private double latitude;
  private double longitude;

}
