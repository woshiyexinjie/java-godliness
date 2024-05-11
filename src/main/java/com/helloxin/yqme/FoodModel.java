package com.helloxin.yqme;

import lombok.Data;

import java.util.List;

@Data
public class FoodModel {
    private String name;
    private List<String> material;
    private String mealType;
}
