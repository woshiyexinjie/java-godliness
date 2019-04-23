package com.helloxin.reflection.sql;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Created by nandiexin on 2019/4/22.
 */
public class ResultSetPropertiesHelper {

    /**
     * 把ResultSet的结果放到java对象中
     *
     * @param <T>
     * @param rs  ResultSet
     * @param obj java类的class
     * @return
     */
    public static <T> ArrayList<T> transferResult(ResultSet rs, Class<T> obj) {
        try {
            Objects.requireNonNull(rs, "ResultSet参数不能为空");
            Objects.requireNonNull(obj, "obj参数不能为空");
            ArrayList<T> arrayList = new ArrayList<T>();
            ResultSetMetaData metaData = rs.getMetaData();
            Field[] fields = obj.getDeclaredFields();

            for (Field field : fields) {
                System.out.println(field.getName());
            }

            int count = metaData.getColumnCount();
            while (rs.next()) {

                T newInstance = obj.getDeclaredConstructor().newInstance();
                for (int i = 1; i <= count; i++) {

                    //这里统一处理为小写字母
                    String name = metaData.getColumnName(i).toLowerCase();
                    name = toJavaField(name);

                    Class<?> type = null;
                    try {
                        type = obj.getDeclaredField(name).getType();// 获取字段类型
                    } catch (NoSuchFieldException e) {
                        //没有定义过 就不处理 不报错
                        continue;
                    }

                    //这里主要处理一下 set方法  一般都是 setXxxxx的方式，当然这里没有胡处理那种有的is开头定义的属性,简单实现一下
//                    String substring = name.substring(0, 1);// 首字母大写
//                    String replace = name.replaceFirst(substring, substring.toUpperCase());
//                    Method method = obj.getMethod("set" + replace, type);

                    Field field = obj.getDeclaredField(name);
                    field.setAccessible(true);
                    if (type.isAssignableFrom(String.class)) {
                        field.set(newInstance, rs.getString(i));
                    } else if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)) {
                        field.set(newInstance, rs.getInt(i));
                    } else if (type.isAssignableFrom(long.class) || type.isAssignableFrom(Long.class)) {
                        field.set(newInstance, rs.getLong(i));
                    } else if (type.isAssignableFrom(BigDecimal.class)) {
                        field.set(newInstance, rs.getBigDecimal(i));
                    } else if (type.isAssignableFrom(boolean.class) || type.isAssignableFrom(Boolean.class)) {
                        field.set(newInstance, rs.getBoolean(i));
                    } else if (type.isAssignableFrom(Date.class)) {
                        field.set(newInstance, rs.getDate(i));
                    }


                    /**
                     * 判断读取数据的类型
                     */
//                    if (type.isAssignableFrom(String.class)) {
//                        method.invoke(newInstance, rs.getString(i));
//                    } else if (type.isAssignableFrom(int.class) || type.isAssignableFrom(Integer.class)) {
//                        method.invoke(newInstance, rs.getInt(i));
//                    } else if (type.isAssignableFrom(long.class) || type.isAssignableFrom(Long.class)) {
//                        method.invoke(newInstance, rs.getLong(i));
//                    } else if (type.isAssignableFrom(BigDecimal.class)) {
//                        method.invoke(newInstance, rs.getBigDecimal(i));
//                    } else if (type.isAssignableFrom(boolean.class) || type.isAssignableFrom(Boolean.class)) {
//                        method.invoke(newInstance, rs.getBoolean(i));
//                    } else if (type.isAssignableFrom(Date.class)) {
//                        method.invoke(newInstance, rs.getDate(i));
//                    }
                }
                arrayList.add(newInstance);
            }
            return arrayList;

        } catch (InstantiationException | IllegalAccessException | SQLException | SecurityException | NoSuchMethodException | IllegalArgumentException
                | InvocationTargetException e) {

            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 数据库命名格式转java命名格式
     *
     * @param str 数据库字段名
     * @return java字段名
     */
    public static String toJavaField(String str) {

        String[] split = str.split("_");
        StringBuilder builder = new StringBuilder();
        builder.append(split[0]);// 拼接第一个字符

        // 如果数组不止一个单词
        if (split.length > 1) {
            for (int i = 1; i < split.length; i++) {
                // 去掉下划线，首字母变为大写
                String string = split[i];
                String substring = string.substring(0, 1);
                split[i] = string.replaceFirst(substring, substring.toUpperCase());
                builder.append(split[i]);
            }
        }

        return builder.toString();
    }
}
