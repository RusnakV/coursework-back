package coursework.model;
import lombok.*;
import javax.persistence.*;
@Entity
@Table(name = "marker_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarkerCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column (name = "title")
    private String title;
}
