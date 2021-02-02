package lk.ijse.dep.web.stm.business.custom;

import lk.ijse.dep.web.stm.business.SuperBO;
import lk.ijse.dep.web.stm.dto.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    public void saveStudent(StudentDTO studentDTO) throws Exception;

    public void updateStudent(StudentDTO studentDTO) throws Exception;

    public void deleteStudent(String studentId) throws Exception;

    public List<StudentDTO> findAllStudents() throws Exception;
}
