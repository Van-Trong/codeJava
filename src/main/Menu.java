/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.Motocycles;
import java.util.ArrayList;
import java.util.Scanner;
import manager.MotocyclesManager;

/**
 *
 * @author PC
 */
/*public class Menu {

    private MotocyclesManager myMotocyclesManager = null;
    private Scanner scan = null;

    public Menu() {

        myMotocyclesManager = new MotocyclesManager();
        scan = new Scanner(System.in);
    }

    public void displayMenu() {
        int job = 0;
        do {
            this.printMenu();
            job = scan.nextInt();
            scan.nextLine();
            switch (job) {
                case 0:
                    doRestoreData();
                    break;
                case 1:
                    doAddMotocycles();
                    break;
                case 2:
                    doFindByName();
                    break;
                case 3:
                    doFindByPriceRange();
                    break;
                case 4:
                    doFindByBrand();
                    break;
                case 5:
                    doFindByYearOfRelease();
                    break;
                case 6:
                    doFindByMassFraction();
                    break;
                case 7:
                    doDeleteMotocycles();
                    break;
                case 8:
                    doEditMotocyclesByID();
                    break;
                case 9:
                   // doEditMotocyclesByQuantity();
                    break;
                case 10:
                    doFindAllMotocycles();
                    break;
                case 11:
                    doSaveDataAsChar();
                    break;
                case 12:
                    doBackupData();
                    doSaveDataAsChar();
                    break;
            }
        } while (job != 12);
    }

    private void doAddMotocycles() {
        
        String image,id, name, brand;
        int quantity;
        float price;
        int year;
        
        System.out.print("Enter Motocycles image: ");
        image =scan.nextLine();
        System.out.print("Enter Motocycles id: ");
        id = scan.nextLine();
        System.out.print("Enter Motocycles name: ");
        name = scan.nextLine();
        System.out.print("Enter Motocycles type: ");
        brand = scan.nextLine();
        System.out.print("Enter Motocycles quantity: ");
        quantity = scan.nextInt();
        System.out.print("Enter price: ");
        price = scan.nextFloat();
        System.out.print("Enter year of release: ");
        year = scan.nextInt();

        Motocycles tempMotocycles = new Motocycles(image, id, name, name, quantity, quantity, price, year);

        if (this.myMotocyclesManager.addMotocycles(tempMotocycles)) {
            System.out.println("Successful");
        } else {
            System.out.println("UnSuccessful");
        }
    }

    private void doFindAllMotocycles() {
        ArrayList<Motocycles> listMotocycles = this.myMotocyclesManager.getlistMotocycles();
        for (int i = 0; i < listMotocycles.size(); i++) {
            this.printMotocyclesInfo(listMotocycles.get(i));
        }
    }

    private void doFindByName() {
        System.out.println("Find the Motocycles by name");
        System.out.print("Enter Motocycles name:");
        String name = scan.nextLine();
        ArrayList<Motocycles> tempMotocycles = this.myMotocyclesManager.getMotocyclesbyName(name);

        if (tempMotocycles.size() != 0) {
            for (int i = 0; i < tempMotocycles.size(); i++) {
                this.printMotocyclesInfo(tempMotocycles.get(i));
            }
        } else {
            System.out.println("Motocycles not found");
        }
    }

    private void doFindByBrand() {
        System.out.println("Find the Motocycles by type");
        System.out.print("Enter Motocycles type:");
        String type = scan.nextLine();
        ArrayList<Motocycles> tempMotocycles = this.myMotocyclesManager.getMotocyclesbyName(type);

        if (tempMotocycles.size() != 0) {
            for (int i = 0; i < tempMotocycles.size(); i++) {
                this.printMotocyclesInfo(tempMotocycles.get(i));
            }
        } else {
            System.out.println("Motocycles not found");
        }
    }

    private void doFindByYearOfRelease() {
        System.out.println("Find the Motocycles by year of release");
        System.out.print("Enter Motocycles YearOfRelease:");
        int yearOfRelease = scan.nextInt();
        ArrayList<Motocycles> tempMotocycles = this.myMotocyclesManager.getMotocyclesbyYearOfRelease(yearOfRelease);

        if (tempMotocycles.size() != 0) {
            for (int i = 0; i < tempMotocycles.size(); i++) {
                this.printMotocyclesInfo(tempMotocycles.get(i));
            }
        } else {
            System.out.println("Motocycles not found");
        }
    }

    private void doFindByMassFraction() {
        System.out.println("Find the Motocycles by MassFraction");
        System.out.print("Enter Motocycles MassFraction:");
        int massFraction = scan.nextInt();
        ArrayList<Motocycles> tempMotocycles = this.myMotocyclesManager.getMotocyclesbyMassFraction(massFraction);

        if (tempMotocycles.size() != 0) {
            for (int i = 0; i < tempMotocycles.size(); i++) {
                this.printMotocyclesInfo(tempMotocycles.get(i));
            }
        } else {
            System.out.println("Motocycles not found");
        }
    }

    private void doFindByPriceRange() {
        System.out.println("Find the Motocycles by price");
        System.out.print("Enter Motocycles priceStart: ");
        int priceStart = scan.nextInt();
        System.out.print("Enter Motocycles priceEnd: ");
        int priceEnd = scan.nextInt();
        ArrayList<Motocycles> tempMotocycles = this.myMotocyclesManager.getMotocyclesbyPriceRange(priceStart, priceEnd);

        if (tempMotocycles.size() != 0) {
            for (int i = 0; i < tempMotocycles.size(); i++) {
                this.printMotocyclesInfo(tempMotocycles.get(i));
            }
        } else {
            System.out.println("Motocycles not found");
        }
    }

    private void doDeleteMotocycles() {
        System.out.println("Delete a Motocycles");
        System.out.print("Enter Motocycles id:");
        String id = scan.nextLine();

        if (this.myMotocyclesManager.deleteMotocyclesbyID(id)) {
            System.out.println("Successful");
        } else {
            System.out.println("UnSuccessful");
        }
    }

    private void doEditMotocyclesByQuantity() {
        String image,id, name, type;
        int quantity;
        float price;
        System.out.print("Enter Motocycles id:");
        id = scan.nextLine();
        Motocycles tempMotocycles = this.myMotocyclesManager.getMotocyclesbyID(id);

        if (tempMotocycles != null) {
            System.out.print("Enter Motocycles quantity: ");
            quantity = scan.nextInt();
            name = tempMotocycles.getName();
            type = tempMotocycles.getBrand();
            price = tempMotocycles.getPrice();
            tempMotocycles = new Motocycles(image, id, name, type, quantity, quantity, price, quantity);
            this.myMotocyclesManager.updateMotocyclesInfo(tempMotocycles, quantity);
        } else {
            System.out.println("Motocycles not found");
        }

    }

    private void doEditMotocyclesByID() {
        String image,id, name, type;
        int quantity;
        float price;
        int year;
        System.out.print("Enter CD id:");
        id = scan.nextLine();
        Motocycles tempMotocycles = this.myMotocyclesManager.getMotocyclesbyID(id);

        if (tempMotocycles != null) {
            System.out.print("Enter motocycles image: ");
             image = scan.nextLine();
            System.out.print("Enter motocycles name: ");
            name = scan.nextLine();
            System.out.print("Enter motocycles type: ");
            type = scan.nextLine();
            System.out.print("Enter motocycles quantity: ");
            quantity = scan.nextInt();
            System.out.print("Enter price: ");
            price = scan.nextFloat();
            System.out.print("Enter year of release: ");
            year = scan.nextInt();

            tempMotocycles = new Motocycles(image, id, name, type, quantity, quantity, price, year);
            this.myMotocyclesManager.updateMotoInfo(tempMotocycles);
        } else {
            System.out.println("motocycles not found");
        }

    }

    private void doBackupData() {
        int count = this.myMotocyclesManager.saveByteData();
        System.out.println(count + " Motocycles have saved");
    }

    private void doRestoreData() {
        int num = this.myMotocyclesManager.getByteData();
        System.out.println("Data is restored, there are " + num + " Motocycles");
    }

    private void doSaveDataAsChar() {

        int count = this.myMotocyclesManager.saveChar();
        System.out.println(count + " Motocycles have saved");
    }

    private void printMotocyclesInfo(Motocycles motocycles) {
        String str = motocycles.getID() + "\t";
        str += motocycles.getName() + "\t";
        str += motocycles.getBrand() + "\t";
        str += motocycles.getQuantity() + "\t\t";
        str += motocycles.getDisplacement() + "\t";
        str += motocycles.getPrice() + "\t";
        str += motocycles.getYearOfRelease() + "\t";
        System.out.println(str);
    }

    private void printMenu() {
        System.out.println("");
        System.out.println("0.Restore data from file");
        System.out.println("1.Add Motocycles");
        System.out.println("2.Search Motocycles by Motocycles name");
        System.out.println("3.Search Motocycles by price range");
        System.out.println("4.Search Motocycles by type");
        System.out.println("5.Search Motocycles by yearOfRelease");
        System.out.println("6.Search Motocycles by massFraction");
        System.out.println("7.Delete Motocycles by Motocycles Id");
        System.out.println("8.Edit CD information by Id");
        System.out.println("9.Edit Motocycles information by Quantity");
        System.out.println("10.Display  all Motocycles");
        System.out.println("11.Save data to file as char");
        System.out.println("12.Exit");
        System.out.print("What do you want? ");
    }
}*/

