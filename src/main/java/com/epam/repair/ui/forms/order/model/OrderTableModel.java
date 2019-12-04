package com.epam.repair.ui.forms.order.model;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.util.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import com.epam.repair.ui.shared.model.DefaultTableModel;
import org.springframework.stereotype.Controller;

@Controller
public class OrderTableModel extends DefaultTableModel<RepairOrder> {

    @Autowired
    private DateFormatter dateFormatter;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RepairOrder repairOrder = entities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return dateFormatter.formatDate(repairOrder.getRepairOrderStartDate());
            case 1:
                return dateFormatter.formatDate(repairOrder.getRepairOrderEndDate());
            case 2:
                return repairOrder.getClient().getFirstName() + " " + repairOrder.getClient().getLastName();
            case 3:
                return repairOrder.getClient().getClientPhoneNumber();
            case 4:
                return repairOrder.getDevice().getDeviceIMEIOrSn();
            case 5:
                return repairOrder.getDevice().getDevicePassword();
            case 6:
                return repairOrder.getDevice().getType().getTypeName();
            case 7:
                return repairOrder.getDevice().getBrand().getBrandName();
            case 8:
                return repairOrder.getDevice().getModel().getModelName();
            case 9:
                return repairOrder.getDevice().getDefect().getDefectName();
            case 10:
                return repairOrder.getDevice().getComplectation().getComplectationName();
            case 11:
                return repairOrder.getDevice().getAppearance().getAppearanceName();
            case 12:
                return repairOrder.getRepairOrderCostEstimated();
            case 13:
                return repairOrder.getStatus().getStatusName();
            default:
                return "";
        }
    }

    @Override
    public String[] getColumnLabels() {
        return new String[]{
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
