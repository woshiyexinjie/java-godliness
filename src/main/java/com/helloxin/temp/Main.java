package com.helloxin.temp;

public class Main {

    public static Float BONE_CHECK_THICKNESS = 3.00F;

    public static Boolean checkBoneDetectThickness(Float thickness) {
        if (thickness == null) {
            return false;
        }
        if (Float.compare(thickness, BONE_CHECK_THICKNESS) > 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(checkBoneDetectThickness(5.00F));

//        List<Float> list = new ArrayList<>();
//        list.add(1.00F);
//        list.add(2.00F);
//        list.add(3.00F);
//        System.out.println(list.stream().min((o1, o2) -> Float.compare(o1,o2)).orElse(null));

//        String aa ="{\n" +
//                "    \"rib_index\": 1,\n" +
//                "    \"origins\":[31.9515,-107.572,-748.46,31.9515,-107.572,-748.46],\n" +
//                "    \"normals\":[1,0,0,1,0,0],\n" +
//                "    \"inslab_normals\":[0,0,1,0,0]\n" +
//                "}";
//        JSONObject a = JSON.parseObject(aa);
////        System.out.println(a.get("origins"));
//        System.out.println(a.getJSONArray("origins").get(1));
//
//        Double a = 0.81141997*227.6165137614679+0.06722586*49.0625+0.02506553*84.1875+8.9615058;
//        System.out.println(a);
    }

}
