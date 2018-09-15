package nebula.platform.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "nebula_group")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "is_system")
    private Boolean isSystem;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getIsSystem() {
        return isSystem;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsSystem(Boolean isSystem) {
        isSystem = isSystem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;

//        return Objects.equals(id, group.id) &&
//                Objects.equals(name, group.name) &&
//                Objects.equals(description, group.description);

        if (group.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), group.getId());

    }

    @Override
    public int hashCode() {
        //return Objects.hash(id, name, description);
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", is_system='" + getIsSystem()+ '\'' +
                '}';
    }
}
