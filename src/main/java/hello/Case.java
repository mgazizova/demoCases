package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cases")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "caseversion")
    private String caseVersion;

    @Column(name = "description")
    private String description;

    @Column(name = "background")
    private String background;

    @Column(name = "casereferences")
    private String caseReferences;
}
