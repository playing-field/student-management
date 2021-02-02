package lk.ijse.dep.web.stm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RegisterPK implements Serializable {
    @Column(name = "student_id")
    int id;
    @Column(name = "course_code")
    String code;
}
