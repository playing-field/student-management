package lk.ijse.dep.web.stm.business.custom.impl;

import lk.ijse.dep.web.stm.business.custom.CourseBO;
import lk.ijse.dep.web.stm.dto.CourseDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseBOImpl implements CourseBO {


    @Override
    public void saveCourse(CourseDTO courseDTO) throws Exception {

    }

    @Override
    public void updateCourse(CourseDTO courseDTO) throws Exception {

    }

    @Override
    public void deleteCourse(String courseId) throws Exception {

    }

    @Override
    public List<CourseDTO> findAllCourses() throws Exception {
        return null;
    }

    @Override
    public void setEntityManager(EntityManager em) {

    }
}
