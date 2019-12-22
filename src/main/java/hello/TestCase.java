package hello;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class TestCase {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String version;

    private String description;

    @ElementCollection
    @Column(name = "ref")
    private List<String> refs;
}
