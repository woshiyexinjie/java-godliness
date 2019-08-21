package com.helloxin.dicom;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che3.data.Value;
import org.dcm4che3.io.DicomInputStream;
import org.dcm4che3.io.DicomOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by nandiexin on 2019/8/15.
 */
public class ReadDicom {


    public static void main(String[] args) {

        DicomInputStream dcmInputStream = null;

        try {

            //读取dicom中的文件信息
            File file = new File("/Users/yexinjie/Documents/Ffy.dcm");
            dcmInputStream = new DicomInputStream(file);
            Attributes dataset = dcmInputStream.readDataset(-1, Tag.PixelData);
//
            System.out.println(dataset.getString(Tag.PatientID));
////

            dataset.setString(Tag.PatientID, VR.LO, "id00003");
            System.out.println(dataset.getString(Tag.PatientID));
//
            dataset.remove(Tag.PatientID);
//
            dataset.setString(Tag.PatientID, VR.LO, "id00004");
            System.out.println(dataset.getString(Tag.PatientID));
//
//            File newfile = new File("/Users/yexinjie/Documents/FfT.dcm");
////            byte[] dicom = WirteDicom.getByte(file);
////            dcmInputStream.close();
////            FileOutputStream fos = new FileOutputStream(newfile);
////            fos.write(dicom);

//            DicomOutputStream dos = new DicomOutputStream(file);
//            dos.writeAttribute(Tag.PatientID, VR.LO, "id00002".getBytes());
//            dos.writeDataset(dcmInputStream.getFileMetaInformation(),dataset);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}