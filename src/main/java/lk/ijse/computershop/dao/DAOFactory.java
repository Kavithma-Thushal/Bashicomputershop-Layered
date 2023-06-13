package lk.ijse.computershop.dao;

import lk.ijse.computershop.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDAOFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, EMPLOYEE, ITEM, DELIVERY, REPAIR, SALARY, ORDERS, ORDERDETAILS, BUILD, BUILDDETAILS, SUPPLIER, SUPPLIERDETAIL, QUERY
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case CUSTOMER:
                return (T) new CustomerDAOImpl();
            case EMPLOYEE:
                return (T) new EmployeeDAOImpl();
            case ITEM:
                return (T) new ItemDAOImpl();
            case DELIVERY:
                return (T) new DeliveryDAOImpl();
            case REPAIR:
                return (T) new RepairDAOImpl();
            case SALARY:
                return (T) new SalaryDAOImpl();
            case ORDERS:
                return (T) new OrdersDAOImpl();
            case ORDERDETAILS:
                return (T) new OrderDetailsDAOImpl();
            case BUILD:
                return (T) new CustombuildsDAOImpl();
            case BUILDDETAILS:
                return (T) new BuildDetailsDAOImpl();
            case SUPPLIER:
                return (T) new SupplierDAOImpl();
            case SUPPLIERDETAIL:
                return (T) new SupplierDetailDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }
}
