/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Motocycles;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author PC
 */
public class MotocyclesDAO {
  private String pathStr = "Data";
    private String fileNameChar = "Motocycles_Data_Character.txt";
    private String fileNameByte = "Motocycles_Data_Byte.txt";

    public void createFolder() {
        File folder = new File(pathStr);
        if (folder.exists()) {
            System.out.println("Folder exist");
        } else {
            folder.mkdirs();
            System.out.println("Folder created");
        }
    }

    public void saveListCDasByte(ArrayList<Motocycles> listMotocycles) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(pathStr + "\\" + fileNameByte);
           
            oos = new ObjectOutputStream(fos);

            oos.writeObject(listMotocycles);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ArrayList<Motocycles> readListCDasByte() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Motocycles> listMotocycles = new ArrayList<>();
        try {
            fis = new FileInputStream(pathStr + "\\" + fileNameByte);
             
            ois = new ObjectInputStream(fis);
            listMotocycles = (ArrayList<Motocycles>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return listMotocycles;
    }

    public void saveListCDasChar(ArrayList<Motocycles> listMotocycles) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(pathStr + "\\" + fileNameChar);
            bw = new BufferedWriter(fw);

            for (int i = 0; i < listMotocycles.size(); i++) {
                bw.write(listMotocycles.get(i).getInfoAsString());
                bw.newLine();
            }

            bw.flush();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fw.close();
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public ArrayList<Motocycles> readListCDasChar() {
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Motocycles> listMotocycles = new ArrayList<>();
        Motocycles temMotocycles;
        try {
            fr = new FileReader(pathStr + "\\" + fileNameChar);
            
            br = new BufferedReader(fr);

            String line = "";
            while ((line = br.readLine()) != null) {
                listMotocycles.add(this.convertStringToCD(line));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return listMotocycles;
    }

    private Motocycles convertStringToCD(String str) {
        StringTokenizer stk = new StringTokenizer(str, ",");
        String image =stk.nextToken();
        String id = stk.nextToken();
        String name = stk.nextToken();
        String brand = stk.nextToken();
        String quantity = stk.nextToken();
        float price = Float.parseFloat(stk.nextToken());
        int year = Integer.parseInt(stk.nextToken());
        return new Motocycles(image, id, name, name, year, year, price, year);
    }  
}