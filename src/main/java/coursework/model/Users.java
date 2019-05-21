package coursework.model;
import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column (name = "login")
    private String login;
    @Column (name = "password")
    private String password;
    @Column (name = "name")
    private String name;
    @Column (name = "status")
    private String status;
}
