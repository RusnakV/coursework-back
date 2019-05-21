package coursework.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "adminmap")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column (name = "adress")
    private String adress;
    @Column (name = "lat")
    private String lat;
    @Column (name = "lng")
    private String lng;
    @Column (name = "startdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startdate;
    @Column (name = "finished")
    private Boolean finished;
    @Column (name = "finishdate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate finishdate;
    @ManyToOne
    @JoinColumn (name = "category_id")
    private Categories categories;
}
