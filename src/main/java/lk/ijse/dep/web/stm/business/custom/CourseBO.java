package lk.ijse.dep.web.stm.business.custom;

import lk.ijse.dep.web.stm.business.SuperBO;
import lk.ijse.dep.web.stm.dto.CourseDTO;

import java.util.List;

public interface CourseBO extends SuperBO {
    public void saveCourse(CourseDTO courseDTO) throws Exception;

    public void updateCourse(CourseDTO courseDTO) throws Exception;

    public void deleteCourse(String courseId) throws Exception;

    public List<CourseDTO> findAllCourses() throws Exception;
}
