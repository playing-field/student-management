package lk.ijse.dep.web.stm.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name="register")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Register implements SuperEntity {
    @EmbeddedId
    private RegisterPK registerPK;
    @Column(name="joined_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registerDate;
    private BigDecimal registerFee;
    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name="student_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;
    @ManyToOne
    @Setter(AccessLevel.NONE)
    @JoinColumn(name="course_code", referencedColumnName = "code", insertable = false, updatable = false)
    private Course course;
}
