package models;

import props.Orders;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public interface IReport {
    List <Orders> ReportOrderList();
    DefaultTableModel reportOrderTable();
}
