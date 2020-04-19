package com.helloxin.image.simpleimage;

import com.alibaba.simpleimage.ImageFormat;
import com.alibaba.simpleimage.ImageRender;
import com.alibaba.simpleimage.SimpleImageException;
import com.alibaba.simpleimage.render.ReadRender;
import com.alibaba.simpleimage.render.ScaleParameter;
import com.alibaba.simpleimage.render.ScaleRender;
import com.alibaba.simpleimage.render.WriteRender;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ZoomImage {

    public static void main(String[] args) {
        File in = new File("/Users/yexinjie/Desktop/test.jpg");      //原图片
        File out = new File("/Users/yexinjie/Desktop/dest.jpg");       //目的图片
        ScaleParameter scaleParam = new ScaleParameter(256, 256);  //将图像缩略到1024x1024以内，不足1024x1024则不做任何处理
//        WriteParameter writeParam = new WriteParameter();   //输出参数，默认输出格式为JPEG

        FileInputStream inStream = null;
        FileOutputStream outStream = null;
        ImageRender wr = null;
        try {
            inStream = new FileInputStream(in);
            outStream = new FileOutputStream(out);
            ImageRender rr = new ReadRender(inStream);
            ImageRender sr = new ScaleRender(rr, scaleParam);
            wr = new WriteRender(sr, outStream, ImageFormat.JPEG);

            wr.render();                            //触发图像处理
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inStream);         //图片文件输入输出流必须记得关闭
            IOUtils.closeQuietly(outStream);
            if (wr != null) {
                try {
                    wr.dispose();                   //释放simpleImage的内部资源
                } catch (SimpleImageException ignore) {
                    // skip ...
                }
            }
        }
    }
}
