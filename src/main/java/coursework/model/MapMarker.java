package coursework.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "map")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MapMarker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "adress")
    private String adress;
    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    @Column(name = "problem")
    private String problem;
    // зв"язки
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;
    @Column(name = "report")
    private Boolean report;

    // for date type
    /*@Column (name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;*/


}
