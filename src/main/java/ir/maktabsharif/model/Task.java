package ir.maktabsharif.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Embeddable
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;


    @Temporal(TemporalType.DATE)
    private Date deadLine;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Enumerated(EnumType.STRING)
    private TaskStates taskStates;

    @ManyToOne
    private Members user;

}
