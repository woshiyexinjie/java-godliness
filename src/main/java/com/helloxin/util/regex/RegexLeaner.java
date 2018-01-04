package com.helloxin.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * create by nandiexin on 2017/12/19
 **/
public class RegexLeaner {

    private static final String REGEX = "\\bcat\\b";

    private static final String REGEX2 = "foo";

    private static final String INPUT =
            "cat cat cat cattie cat";

    private static final String INPUT2 = "ooooofoooooooooooo";

    private static final String INPUT3 = "fooooooooooooooooo";

    private static String REGEX4 = "dog";
    private static String INPUT4 = "The dog says meow. " +
            "All dogs say meow.";
    private static String REPLACE = "cat";

    private static Pattern pattern;
    private static Matcher matcher;
    private static Matcher matcher2;

    /**
     *  这里只是试一下java正则表达式的
     *  其中Patter.matches 执行了  其实一般替换也是一样的
     *  Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
     */
    public static void regex(){
        String content = "I am noob from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    /**
     * 捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。
     * 捕获组是通过从左至右计算其开括号来编号
     */
    public static void regexGroup(){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);

        System.out.println("groupCount:"+m.groupCount());
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

    /**
     *
     */
    public  static void regexStartEnd(){
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    }

    /**
     * atches 和 lookingAt 方法都用来尝试匹配一个输入序列模式。它们的不同是 matches 要求整个序列都匹配，而lookingAt 不要求。
     lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。
     */
    public static void regexLookingAt(){
        pattern = Pattern.compile(REGEX2);
        matcher = pattern.matcher(INPUT3);
        matcher2 = pattern.matcher(INPUT2);

        System.out.println("Current REGEX is: "+REGEX2);
        System.out.println("Current INPUT is: "+INPUT3);
        System.out.println("Current INPUT2 is: "+INPUT2);


        System.out.println("lookingAt(): "+matcher.lookingAt());
        System.out.println("matches(): "+matcher.matches());
        System.out.println("lookingAt(): "+matcher2.lookingAt());
    }

    /**
     * replaceFirst 和 replaceAll 方法用来替换匹配正则表达式的文本。
     * 不同的是，replaceFirst 替换首次匹配，replaceAll 替换所有匹配。
     */
    public static void regexReplace(){

        Pattern p = Pattern.compile(REGEX4);
        // get a matcher object
        Matcher m = p.matcher(INPUT4);
        INPUT4 = m.replaceAll(REPLACE);
        System.out.println(INPUT4);
    }



    public static void main(String[] args) {

        regexReplace();

    }
}
