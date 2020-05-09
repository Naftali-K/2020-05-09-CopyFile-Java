package com.HomeWork;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<String> filesName = new ArrayList<>();
        String nameFileOriginal = "New File";
        byte[] buffer = null;

        File folderOriginal = new File("../2020-05-09-FilesForCopy/Folder1"); //folder where have original file
            File fileOriginal = new File(folderOriginal, "OriginalFile.TXT");
            //printAllInFolder(folderOriginal); //testing what have inside of folder
            if(checkFile(fileOriginal)){
                nameFileOriginal = fileOriginal.getName();

                buffer = readFile(fileOriginal);
            }

        File folderCopy = new File("../2020-05-09-FilesForCopy/Folder2"); //folder to where need make copy of file
            File newFile = new File(folderCopy, "Copy" + nameFileOriginal);
            if(!checkFile(newFile)){//checking if have file with same name in folder or not
                //if file not have in folder, so can create new file
                newFile.createNewFile();
                System.out.println("Made new Copy file");

                writeToFile(newFile, buffer);

            }else{
                //other can't create file
                System.out.println("File with this name already have in folder");
            }

    }




    //method for check what have in the folder
    public static void printAllInFolder(File scr){
        for (File nameFile : scr.listFiles()) {
            System.out.println(nameFile.getName());
        }
    }

    //checking if have this kind file
    public static boolean checkFile(File file){
        boolean result;
        if(file.exists()){
//            System.out.println("File found");
            result = true;
        }else{
//            System.out.println("File NOT found");
            result = false;
        }

        return result;
    }

    //read all file, and back array list of bytes with text from file
    public static byte[] readFile(File file) throws IOException {

        FileInputStream fileReadText = new FileInputStream(file); //open file for read the file
        byte[] buffer = new byte[fileReadText.available()]; //checking how many bytes text in file
        fileReadText.read(buffer); //transfer text by byte to array list of bytes

        return buffer;
    }

    //write text to the file
    public static void writeToFile(File file, byte[] text) throws IOException {
        FileOutputStream fileForWrite = new FileOutputStream(file);//opening file for write
        fileForWrite.write(text);//writing text (in bytes) to new file
    }
}
