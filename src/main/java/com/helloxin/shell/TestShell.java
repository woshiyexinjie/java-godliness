package com.helloxin.shell;

import org.buildobjects.process.ProcBuilder;

/**
 * Created by yebanxian on 2020/4/17.
 */
public class TestShell {

    //https://github.com/fleipold/jproc
    public static void main(String[] args) {

        String output = ProcBuilder.run("echo", "Hello World!");

        System.out.println(output);

        String output2 = ProcBuilder.run("pwd");

        System.out.println(output2);

        String output3 = ProcBuilder.filter("x y z", "sed", "s/y/a/");

        System.out.println(output3);
    }
}
