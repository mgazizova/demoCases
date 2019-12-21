package hello;

import javax.persistence.*;

@Entity
@Table(name = "cases")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaseVersion() {
        return caseVersion;
    }

    public void setCaseVersion(String caseVersion) {
        this.caseVersion = caseVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getCaseReferences() {
        return caseReferences;
    }

    public void setCaseReferences(String caseReferences) {
        this.caseReferences = caseReferences;
    }
}
