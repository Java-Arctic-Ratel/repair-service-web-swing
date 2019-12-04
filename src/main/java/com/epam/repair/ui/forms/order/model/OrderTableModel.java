package com.epam.repair.ui.forms.order.model;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.util.DateFormatter;
import org.springframework.stereotype.Component;
import com.epam.repair.ui.shared.model.DefaultTableModel;

@Component
public class OrderTableModel extends DefaultTableModel<RepairOrder> {

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RepairOrder repairOrder = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return repairOrder.getRepairOrderId();
            case 1:
                return DateFormatter.formatDate(repairOrder.getRepairOrderStartDate());
            case 2:
                return DateFormatter.formatDate(repairOrder.getRepairOrderEndDate());
            case 3:
                return repairOrder.getClient().getFirstName() + " " + repairOrder.getClient().getLastName();
            case 4:
                return repairOrder.getClient().getClientPhoneNumber();
            case 5:
                return repairOrder.getDevice().getDeviceIMEIOrSn();
            case 6:
                return repairOrder.getDevice().getDevicePassword();
            case 7:
                return repairOrder.getDevice().getType().getTypeName();
            case 8:
                return repairOrder.getDevice().getBrand().getBrandName();
            case 9:
                return repairOrder.getDevice().getModel().getModelName();
            case 10:
                return repairOrder.getDevice().getDefect().getDefectName();
            case 11:
                return repairOrder.getDevice().getComplectation().getComplectationName();
            case 12:
                return repairOrder.getDevice().getAppearance().getAppearanceName();
            case 13:
                return repairOrder.getRepairOrderCostEstimated();
            case 14:
                return repairOrder.getStatus().getStatusName();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                "ID",
                "StartDate",
                "EndDate",
                "Client",
                "PhoneNumber",
                "IMEIorSN",
                "Pswrd",
                "Type",
                "Brand",
                "Model",
                "Defect",
                "Complect",
                "Appear",
                "CostEst",
                "Status"};
    }
}
