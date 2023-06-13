package lk.ijse.computershop.bo;

import lk.ijse.computershop.bo.custom.impl.*;

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory() {

    }

    public static BoFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    }

    public enum BOTypes {
        CUSTOMER, EMPLOYEE, ITEM, DELIVERY, REPAIR, SALARY, ORDERS, BUILD, SUPPLIER
    }

    public <T extends SuperBO> T getBO(BOTypes boTypes) {
        switch (boTypes) {
            case CUSTOMER:
                return (T) new CustomerBOImpl();
            case EMPLOYEE:
                return (T) new EmployeeBOImpl();
            case ITEM:
                return (T) new ItemBOImpl();
            case DELIVERY:
                return (T) new DeliveryBOImpl();
            case REPAIR:
                return (T) new RepairBOImpl();
            case SALARY:
                return (T) new SalaryBOImpl();
            case ORDERS:
                return (T) new OrdersBOImpl();
            case BUILD:
                return (T) new CustombuildsBOImpl();
            case SUPPLIER:
                return (T) new SupplierBOImpl();
            default:
                return null;
        }
    }
}
