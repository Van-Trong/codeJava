/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;


import entity.Motocycles;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Admin
 */
public class MotocyclesTableModel extends AbstractTableModel {

    private String[] columnNames = {"ID", "Name", "Brand", "MassFraction(cc)", "Quantity","Year of release","Price(VND)"};
    private ArrayList<Motocycles> listData;
    private ArrayList<Object[]> listRow = new ArrayList<>();
    

    public MotocyclesTableModel(ArrayList<Motocycles> listData) {
        this.listData = listData;
        Motocycles temp;
        for (int i = 0; i < this.listData.size(); i++) {
            temp = this.listData.get(i);
            Object[] row = {temp.getID(), temp.getName(), temp.getBrand(), temp.getDisplacement(), temp.getQuantity(),temp.getYearOfRelease(),temp.getPrice()};
            this.listRow.add(row);
        }
    }

    public int getRowCount() {
        return this.listRow.size();
    }

    public int getColumnCount() {
        return this.columnNames.length;
    }

    public Object getValueAt(int row, int column) {
        return this.listRow.get(row)[column];
    }

    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    public java.lang.Class getColumnClass(int column) {
        return this.listRow.get(0)[column].getClass();
    }

    public Object getObjectAtRow(int row) {
        return this.listData.get(row);
    }
}
