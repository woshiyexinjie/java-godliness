package com.helloxin.dicom;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.io.DicomOutputStream;

import java.io.*;

import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;

/**
 * Created by nandiexin on 2019/8/20.
 */
public class WirteDicom {


    public static void main(String[] args) throws Exception {

        //保存图片 模仿有人给我传字节流的数据
        File file = new File("/Users/yexinjie/Documents/1.2.156.112605.14038004227650.20160531220454.4.7820.1.dcm");
        DicomInputStream dcmInputStream = new DicomInputStream(file);
        Attributes dataset = dcmInputStream.readDataset(-1, Tag.PixelData);

        System.out.println(dataset.getString(Tag.PatientID));

        File newfile = new File("/Users/yexinjie/Documents/Ffffffffffffffffff.dcm");
        byte[] dicom = getByte(file);
        dcmInputStream.close();
        FileOutputStream fos = new FileOutputStream(newfile);
        fos.write(dicom);
    }

    public static byte[] getByte(File file) throws Exception {
        byte[] bytes = null;
        if (file != null) {
            InputStream is = new FileInputStream(file);
            int length = (int) file.length();
            if (length > Integer.MAX_VALUE)   //当文件的长度超过了int的最大值
            {
                System.out.println("this file is max ");
                return null;
            }
            bytes = new byte[length];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }
            //如果得到的字节长度和file实际的长度不一致就可能出错了
            if (offset < bytes.length) {
                System.out.println("file length is error");
                return null;
            }
            is.close();
        }
        return bytes;
    }
}
