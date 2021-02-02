package lk.ijse.dep.web.stm.entity;

import lk.ijse.dep.web.stm.util.Gender;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;


@ToString(exclude = "registerCourses")
@Table(name = "student")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements SuperEntity {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;
    @Column(name = "student_name")
    private String studentName;
    private Date dob;
    private String contact;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Setter(AccessLevel.NONE)
    @OneToMany(mappedBy = "student")
    private List<Register> registerCourses;




}
