package lk.ijse.dep.web.stm.business.util;


import lk.ijse.dep.web.stm.dto.StudentDTO;
import lk.ijse.dep.web.stm.entity.Student;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;



@Mapper
public interface EntityDTOMapper {

    EntityDTOMapper instance = Mappers.getMapper(EntityDTOMapper.class);

    Student getStudent(StudentDTO dto);







}
