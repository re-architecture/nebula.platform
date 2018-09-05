package nebula.platform.service;

import nebula.platform.service.dto.GroupDTO;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface GroupService {

    GroupDTO save(GroupDTO groupDTO);

    List<GroupDTO> findAll();

    Optional<GroupDTO> findOne(Long id);

    void delete(Long id);

}
