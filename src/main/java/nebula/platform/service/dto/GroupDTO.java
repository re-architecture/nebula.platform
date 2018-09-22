package nebula.platform.service.dto;

import nebula.platform.domain.Group;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class GroupDTO implements Serializable {
    private Long id;

    @NotNull
    private String name;

    private String description;

    private  Boolean isSystem;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public void setIsSystem(Boolean isSystem) {
        this.isSystem = isSystem;
    }

    public GroupDTO() {
        // Empty constructor needed for Jackson.
    }

    public GroupDTO(Group group) {
        this.id = group.getId();
        this.name = group.getName();
        this.description = group.getDescription();
        this.isSystem = group.getIsSystem();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDTO groupDTO = (GroupDTO) o;
//        return Objects.equals(getId(), groupDTO.getId()) &&
//                Objects.equals(getName(), groupDTO.getName()) &&
//                Objects.equals(getDescription(), groupDTO.getDescription());

        if (groupDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), groupDTO.getId());
    }

    @Override
    public int hashCode() {
        //return Objects.hash(getId());
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", is_system='" + isSystem + '\'' +
                '}';
    }
}
