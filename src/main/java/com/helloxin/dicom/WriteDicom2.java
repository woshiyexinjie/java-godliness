package com.helloxin.dicom;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.io.DicomOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by nandiexin on 2019/8/15.
 */
public class WriteDicom2 {


    public static void main(String[] args) {

        DicomInputStream dcmInputStream = null;

        try {

            //读取dicom中的文件信息
            File file = new File("/Users/yexinjie/Documents/Ffffffffffffffffff.dcm");
            dcmInputStream = new DicomInputStream(file);
            Attributes data = dcmInputStream.readDataset(-1, Tag.PixelData);
            Attributes fmi = dcmInputStream.readFileMetaInformation();
            data.setString(Tag.PatientID, VR.LO, "id00002");


            File file2 = new File("/Users/yexinjie/Documents/Ffy.dcm");
            DicomOutputStream dos = new DicomOutputStream(file2);
            dos.writeDataset(fmi, data);
            dos.finish();
            dos.flush();
            dos.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}