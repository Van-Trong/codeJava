/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.MotocyclesDAO;
import entity.Motocycles;
import java.util.ArrayList;
import tableModel.MotocyclesTableModel;

/**
 *
 * @author PC
 */
public class MotocyclesManager {

    private ArrayList<Motocycles> listMotocycles;
    private MotocyclesDAO myMotocyclesDAO = null;

    public MotocyclesManager() {
        myMotocyclesDAO = new MotocyclesDAO();
       myMotocyclesDAO.createFolder();
        this.listMotocycles = new ArrayList<>();

    }

    public ArrayList<Motocycles> getlistMotocycles() {
        return listMotocycles;
    }

    public Motocycles getMotocyclesbyID(String id) {
        Motocycles motocycles = null;
        for (int i = 0; i < listMotocycles.size(); i++) {
            if (listMotocycles.get(i).getID().equalsIgnoreCase(id)) {
                motocycles = this.listMotocycles.get(i);
            }
        }

        return motocycles;
    }

    public boolean addMotocycles(Motocycles _motocycles) {
        boolean result = false;
        if (this.getMotocyclesbyID(_motocycles.getID()) == null) {
            this.listMotocycles.add(_motocycles);
            result = true;
        }
        return result;
    }
    
    
    public ArrayList<Motocycles> getMotocyclesbyName(String name) {
        ArrayList<Motocycles> resultListMotocycles = new ArrayList<>();
        for (int i = 0; i < listMotocycles.size(); i++) {
            if (listMotocycles.get(i).getName().equalsIgnoreCase(name)) {
                resultListMotocycles.add(listMotocycles.get(i));
            }
        }
        return resultListMotocycles;
    }

    public ArrayList<Motocycles> getMotocyclesbyBrand(String brand) {
        ArrayList<Motocycles> resultListMotocycles = new ArrayList<>();
        for (int i = 0; i < listMotocycles.size(); i++) {
            if (listMotocycles.get(i).getBrand().equalsIgnoreCase(brand)) {
                resultListMotocycles.add(listMotocycles.get(i));
            }
        }
        return resultListMotocycles;
    }
    public ArrayList<Motocycles> getMotocyclesbyYearOfRelease(int yearOfRelease) {
        ArrayList<Motocycles> resultListMotocycles = new ArrayList<>();
        for (int i = 0; i < listMotocycles.size(); i++) {
            if (listMotocycles.get(i).getYearOfRelease()==yearOfRelease) {
                resultListMotocycles.add(listMotocycles.get(i));
            }
        }
        return resultListMotocycles;
    }
    public ArrayList<Motocycles> getMotocyclesbyMassFraction(int massFraction) {
        ArrayList<Motocycles> resultListMotocycles = new ArrayList<>();
        for (int i = 0; i < listMotocycles.size(); i++) {
            if (listMotocycles.get(i).getDisplacement()==massFraction) {
                resultListMotocycles.add(listMotocycles.get(i));
            }
        }
        return resultListMotocycles;
    }

    public ArrayList<Motocycles> getMotocyclesbyPriceRange(int priceStart, int priceEnd) {
        ArrayList<Motocycles> resultListMotocycles = new ArrayList<>();
        for (int i = 0; i < listMotocycles.size(); i++) {
            if (listMotocycles.get(i).getPrice() >= priceStart && listMotocycles.get(i).getPrice() <= priceEnd) {
                resultListMotocycles.add(listMotocycles.get(i));
            }
        }
        return resultListMotocycles;
    }

    public boolean deleteMotocyclesbyID(String id) {
        boolean res = false;
        Motocycles tempMotocycles = this.getMotocyclesbyID(id);
        if (tempMotocycles != null) {
            this.listMotocycles.remove(tempMotocycles);
            res = true;
        }
        return res;
    }

    public boolean updateMotoInfo(Motocycles moto) {
        boolean isSucc = false;
        for (int i = 0; i < this.listMotocycles.size(); i++) {
            if (this.listMotocycles.get(i).getID().equalsIgnoreCase(moto.getID())) {
                this.listMotocycles.remove(i);
                this.listMotocycles.add(i, moto);
                isSucc = true;
                break;

            }
        }
        return isSucc;
    }

    public int saveByteData() {
        this.myMotocyclesDAO.saveListCDasByte(listMotocycles);
        return this.listMotocycles.size();
    }

    public int getByteData() {
        this.listMotocycles = this.myMotocyclesDAO.readListCDasByte();
        return listMotocycles.size();
    }

    public int saveChar() {
        this.myMotocyclesDAO.saveListCDasChar(listMotocycles);
        return this.listMotocycles.size();
    }
    public MotocyclesTableModel getMotocyclesTableModel() {
        MotocyclesTableModel motoTblModel = new MotocyclesTableModel(listMotocycles);
        return motoTblModel;
    }
    
    public MotocyclesTableModel getMotocyclesSortPriceIncrease() {
         listMotocycles.sort((moto1,moto2)->Float.compare(moto1.getPrice(),moto2.getPrice()));
        MotocyclesTableModel motoTblModel = new MotocyclesTableModel(listMotocycles);
        return motoTblModel;
    }
    public MotocyclesTableModel getMotocyclesSortPriceDecrease() {
         listMotocycles.sort((moto1,moto2)->Float.compare(moto2.getPrice(),moto1.getPrice()));
        MotocyclesTableModel motoTblModel = new MotocyclesTableModel(listMotocycles);
        return motoTblModel;
    }
     public MotocyclesTableModel getMotocyclesSortYearIncrease() {
          listMotocycles.sort((moto1,moto2)->Integer.compare(moto1.getYearOfRelease(),moto2.getYearOfRelease()));
        MotocyclesTableModel motoTblModel = new MotocyclesTableModel(listMotocycles);
        return motoTblModel;
    }
    public MotocyclesTableModel getMotocyclesSortYearDecrease() {
        listMotocycles.sort((moto1,moto2)->Integer.compare(moto2.getYearOfRelease(),moto1.getYearOfRelease()));
        MotocyclesTableModel motoTblModel = new MotocyclesTableModel(listMotocycles);
        return motoTblModel;
    }
     public MotocyclesTableModel getMotocyclesFindName(String name) {
    ArrayList<Motocycles> resultListMotocycles = new ArrayList<>();
        for (int i = 0; i < listMotocycles.size(); i++) {
            if (listMotocycles.get(i).getName().equalsIgnoreCase(name)) {
                resultListMotocycles.add(listMotocycles.get(i));
            }
        }
         MotocyclesTableModel motoTblModel = new MotocyclesTableModel(resultListMotocycles);
        return motoTblModel;
     }
}
