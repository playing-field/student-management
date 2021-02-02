package lk.ijse.dep.web.stm.dao;

import lk.ijse.dep.web.stm.dao.custom.impl.CourseDAOImpl;
import lk.ijse.dep.web.stm.dao.custom.impl.RegisterDAOImpl;
import lk.ijse.dep.web.stm.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        return (daoFactory != null)? daoFactory: (daoFactory = new DAOFactory());
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType){
        switch (daoType){
            case STUDENT:
                return (T) new StudentDAOImpl();

            case COURSE:
                return (T) new CourseDAOImpl();
            case REGISTER:
                return (T) new RegisterDAOImpl();

            default:
                return null;
        }
    }

}
