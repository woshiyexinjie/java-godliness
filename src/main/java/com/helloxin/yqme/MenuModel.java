package com.helloxin.yqme;

import lombok.Data;

import java.util.List;

@Data
public class MenuModel {
    private String date;
    private List<FoodModel> foods;
}