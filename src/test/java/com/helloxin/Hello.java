package com.helloxin;


import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by nandiexin on 2018/2/26.
 */
public class Hello {

    public void Try(int a[]){
        int temp;
        for (int i =0; i<a.length; i++) {
            for (int j=i+1; j<a.length; j++) {
// System.out.println(a[i]);
                if (a[i]<a[j]) {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
            for (int t =0;t<a.length ;t++ ) {
                System.out.print(a[t]+" ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {

        int arr[] = {23,34,32,12,53,89,76,11,8};
        int i;
        for (i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]<arr[j+1])
                {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }

//        Hello h = new Hello();
//        h.Try(arr);
        for ( i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
