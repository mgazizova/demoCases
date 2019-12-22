package hello;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "user_")
@Getter
@Setter
@EqualsAndHashCode(of = "login")
public class User {
    @Id
    private String login;
    private String password;
}
