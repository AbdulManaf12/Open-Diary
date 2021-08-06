package OperatingSystemTopics;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FilingData
{
    public boolean AddRecords(String records){
        boolean flag = false;
        if (!isEmailExists(records.split(",")[2])) {
            File file = new File(Constants.fileName);
            try {
                if(!file.exists())
                    file.createNewFile();
                ArrayList<String> list = new ArrayList();
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()){
                    list.add(sc.nextLine());
                }
                sc.close();

                PrintWriter pw = new PrintWriter(file);
                for (int i=0; i<list.size(); i++){
                    pw.println(list.get(i));
                }
                pw.println(records);
                pw.close();
                flag = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            JOptionPane.showMessageDialog(null,"Already exists ... !");
        }
        return flag;
    }

    public String SearchRecord(String email){
        File file = new File(Constants.fileName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
                String t = sc.nextLine();
                String arr[] = t.split(",");
                if (arr[2].equalsIgnoreCase(email)){
                    return t;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteRecord(String email){
        boolean flag = false;
        File file = new File(Constants.fileName);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {

        }
        ArrayList<String> arrayList = new ArrayList<>();
        while (sc.hasNext()){
            String temp = sc.nextLine();
            if (email.equalsIgnoreCase(temp.split(",")[2])) {
                continue;
            }
            arrayList.add(temp);
        }
        sc.close();

        try {
            PrintWriter pw = new PrintWriter(Constants.fileName);
            for (int i=0; i<arrayList.size(); i++){
                pw.println(arrayList.get(i));
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean isEmailExists(String email){
        boolean flag = false;
        File file = new File(Constants.fileName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()){
                String arr[] = sc.nextLine().split(",");
                if (arr[2].equalsIgnoreCase(email)){
                    flag = true;
                    break;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return flag;
    }
}