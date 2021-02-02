package lk.ijse.dep.web.stm.business.util;

import java.sql.Date;
import java.time.ZoneOffset;
import javax.annotation.Generated;
import lk.ijse.dep.web.stm.dto.StudentDTO;
import lk.ijse.dep.web.stm.entity.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-02T07:18:03+0530",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class EntityDTOMapperImpl implements EntityDTOMapper {

    @Override
    public Student getStudent(StudentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( dto.getId() );
        student.setStudentName( dto.getStudentName() );
        if ( dto.getDob() != null ) {
            student.setDob( new Date( dto.getDob().atStartOfDay( ZoneOffset.UTC ).toInstant().toEpochMilli() ) );
        }
        student.setContact( dto.getContact() );
        student.setGender( dto.getGender() );

        return student;
    }
}
