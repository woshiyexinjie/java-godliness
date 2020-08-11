package com.helloxin.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by yebanxian on 2020/4/24.
 */
public class evalTest {
    //也可以用 Aviator表达式求值引擎
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine se = manager.getEngineByName("js");
        String str = "1+2*(3+6)-5/2";
        Double result = (Double) se.eval(str);
        System.out.println(result);
    }
}
