package lk.ijse.dep.web.stm.business.custom.impl;

import lk.ijse.dep.web.stm.business.custom.StudentBO;
import lk.ijse.dep.web.stm.business.util.EntityDTOMapper;
import lk.ijse.dep.web.stm.dao.DAOFactory;
import lk.ijse.dep.web.stm.dao.DAOTypes;
import lk.ijse.dep.web.stm.dao.custom.StudentDAO;
import lk.ijse.dep.web.stm.dto.CourseDTO;
import lk.ijse.dep.web.stm.dto.StudentDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private  StudentDAO studentDAO;
    private EntityManager em;
    private final EntityDTOMapper mapper = EntityDTOMapper.instance;

    public StudentBOImpl() {
        studentDAO = DAOFactory.getInstance().getDAO(DAOTypes.STUDENT);
    }

    @Override
    public void saveStudent(StudentDTO studentDTO) throws Exception {
//        mapper.getStudent(studentDTO)
        studentDAO.save(mapper.getStudent(studentDTO));
        System.out.println(mapper.getStudent(studentDTO));
    }

    @Override
    public void updateStudent(StudentDTO studentDTO) throws Exception {

    }

    @Override
    public void deleteStudent(String studentId) throws Exception {

    }

    @Override
    public List<StudentDTO> findAllStudents() throws Exception {
        return null;
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
        studentDAO.setEntityManager(em);

    }
}
