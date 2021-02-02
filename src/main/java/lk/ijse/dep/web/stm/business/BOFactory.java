package lk.ijse.dep.web.stm.business;

import lk.ijse.dep.web.stm.business.custom.impl.CourseBOImpl;
import lk.ijse.dep.web.stm.business.custom.impl.RegisterBOImpl;
import lk.ijse.dep.web.stm.business.custom.impl.StudentBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }

    public static BOFactory getInstance() {
        return (boFactory != null) ? boFactory : (boFactory = new BOFactory());
    }

    public <T extends lk.ijse.dep.web.stm.business.SuperBO> T getBO(BOTypes boType) {
        switch (boType) {
            case COURSE:
                return (T) new CourseBOImpl();
            case STUDENT:
                return (T) new StudentBOImpl();
            case REGISTER:
                return (T) new RegisterBOImpl();
            default:
                return null;
        }
    }
}
