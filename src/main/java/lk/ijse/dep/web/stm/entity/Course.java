package lk.ijse.dep.web.stm.entity;

import lk.ijse.dep.web.stm.util.Audience;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString(exclude = "registeredStudents")
@Entity
@Table(name = "course")
@AllArgsConstructor
@NoArgsConstructor
public class Course implements SuperEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    String code;
    String description;
    String duration;
    @Enumerated(EnumType.ORDINAL)
    Audience audience;
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "course")
    private List<Student> registeredStudents;

}
