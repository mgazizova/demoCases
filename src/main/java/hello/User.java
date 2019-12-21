package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author vtarasov
 * @since 22.12.2019
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    private String login;

    private String password;
}
