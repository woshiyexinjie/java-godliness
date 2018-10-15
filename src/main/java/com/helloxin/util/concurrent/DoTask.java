package com.helloxin.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class DoTask extends RecursiveAction{


    // 处理最多十条数据
    private static final int THRESHOLD = 10;
    private int start;
    private int end;
    List<String> list = null;
    // 从start到end的任务
    public DoTask(int start, int end, List<String> list)
    {
        this.start = start;
        this.end = end;
        this.list = list;
    }

    @Override
    protected void compute() {
        // TODO Auto-generated method stub
        if(end - start < THRESHOLD){
            String mobileno="";
            for (int i = start ; i < end ; i++ )
            {
                //此处做累加
                mobileno+=list.get(i)+",";
            }
            System.out.println("处理=="+mobileno+"的数据");
        }else{
            // 如果当end与start之间的差大于THRESHOLD时，即要发送的数超过10个
            // 将大任务分解成两个小任务。
            int middle = (start + end) /2;
            DoTask left = new DoTask(start, middle,list);
            DoTask right = new DoTask(middle, end,list);
            // 并行执行两个“小任务”
            left.fork();
            right.fork();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        List<String> list = new ArrayList<String>();
        for(int i=1;i<=380;i++){
            list.add("i-"+i);//初始化一个数组
        }
        ForkJoinPool pool = new ForkJoinPool();
        // 提交可分解的任务
        pool.submit(new DoTask(0 , list.size(),list));
        //线程阻塞，等待所有任务完成
        pool.awaitTermination(10, TimeUnit.SECONDS);
        // 关闭线程池
        pool.shutdown();

    }

}