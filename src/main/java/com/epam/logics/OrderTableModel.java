package com.epam.logics;

import com.epam.model.RepairOrder;
import org.springframework.stereotype.Component;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

@Component
public class OrderTableModel extends AbstractTableModel {

    List<RepairOrder> repairOrders = new ArrayList<RepairOrder>();
    private String[] columnNames = {"ID", "StartDate", "Status", "endDate", "Client", "defect", "type", "IMEIorSN", "Brand", "Model", "Appearance", "complectation", "pswrd", "cost"};

    public OrderTableModel() {
    }

    public OrderTableModel(List<RepairOrder> repairOrders) {
        this.repairOrders = repairOrders;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return repairOrders.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object orderAttribute = null;
        RepairOrder orderObject = repairOrders.get(row);
        switch (column) {
            case 0:
                orderAttribute = orderObject.getRepairOrderId();
                break;
            case 1:
                orderAttribute = orderObject.getRepairOrderStartDate();
                break;
            case 2:
                orderAttribute = orderObject.getStatus().statusName;
                break;
            case 3:
                orderAttribute = orderObject.getRepairOrderEndDate();
                break;
            case 4:
                orderAttribute = orderObject.getClient().firstName + " " + orderObject.getClient().lastName;
                break;
            case 5:
                orderAttribute = orderObject.getDevice().defect.defectName;
                break;
            case 6:
                orderAttribute = orderObject.getDevice().type.typeName;
                break;
            case 7:
                orderAttribute = orderObject.getDevice().deviceIMEIOrSn;
                break;
            case 8:
                orderAttribute = orderObject.getDevice().brand.brandName;
                break;
            case 9:
                orderAttribute = orderObject.getDevice().model.modelName;
                break;
            case 10:
                orderAttribute = orderObject.getDevice().appearance.appearanceName;
                break;
            case 11:
                orderAttribute = orderObject.getDevice().complectation.complectationName;
                break;
            case 12:
                orderAttribute = orderObject.getDevice().devicePassword;
                break;
            case 13:
                orderAttribute = orderObject.getRepairOrderCostEstimated();
                break;
            default:
                break;
        }
        return orderAttribute;
    }

    public void addOrder(RepairOrder repairOrder) {
        repairOrders.add(repairOrder);
        fireTableDataChanged();
    }
}
