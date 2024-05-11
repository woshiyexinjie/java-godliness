package com.helloxin.yqme;

import com.alibaba.fastjson.JSON;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenerateMenu {

    final static String filePath = "/Users/yexinjie/Documents/family/menufood/";

    public static void main(String[] args) {
        MenuModel menuModel = new MenuModel();
        Date now = new Date();
        // 使用 DateFormat 对象来格式化当前日期
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        // 返回格式化后的日期字符串
        String currentDate = dateFormat.format(now);
        menuModel.setDate(currentDate);

        List<FoodModel> foods = new ArrayList<>();
        FoodModel foodModel1 = new FoodModel();
        foods.add(foodModel1);
        foodModel1.setName("豆腐香菜鸡蛋汤");

        List<String> material1 = new ArrayList<>();
        foodModel1.setMaterial(material1);
        material1.add("豆腐");
        material1.add("香菜");
        material1.add("鸡蛋");
        foodModel1.setMealType(MealTypeEnum.DINNER.name());

        FoodModel foodModel2 = new FoodModel();
        foods.add(foodModel2);
        foodModel2.setName("四季豆炒肉");
        List<String> material2 = new ArrayList<>();
        foodModel2.setMaterial(material1);
        material2.add("四季豆");
        material2.add("五花肉");
        foodModel2.setMealType(MealTypeEnum.DINNER.name());

        FoodModel foodModel3 = new FoodModel();
        foods.add(foodModel3);
        foodModel3.setName("茭白炒肉");
        List<String> material3 = new ArrayList<>();
        foodModel3.setMaterial(material1);
        material3.add("茭白");
        material3.add("五花肉");
        foodModel3.setMealType(MealTypeEnum.DINNER.name());

        menuModel.setFoods(foods);

        String file = filePath + currentDate + "menu.json";
        System.out.println(JSON.toJSONString(menuModel));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            // 向文件中写入内容
            writer.write(JSON.toJSONString(menuModel));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
