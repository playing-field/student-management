package lk.ijse.dep.web.stm.business.util;

import lk.ijse.dep.web.stm.dto.StudentDTO;
import lk.ijse.dep.web.stm.entity.Student;
import lk.ijse.dep.web.stm.util.Gender;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
public class EntityDTOMapperTest {

    @Test
    public void getStudent() {
        Student student = EntityDTOMapper.instance.getStudent(new StudentDTO("dfhksdf", "sdkhf", "ssdjklf", LocalDate.now(), Gender.MALE));
        System.out.println(student);
    }
}
