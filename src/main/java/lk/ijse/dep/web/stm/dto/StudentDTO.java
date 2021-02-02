package lk.ijse.dep.web.stm.dto;

import lk.ijse.dep.web.stm.util.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String id;
    private String studentName;
    private String contact;
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate dob;
    private Gender gender;
}
