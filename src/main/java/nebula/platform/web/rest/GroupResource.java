package nebula.platform.web.rest;

import com.codahale.metrics.annotation.Timed;
import nebula.platform.service.GroupService;
import nebula.platform.service.dto.GroupDTO;
import nebula.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GroupResource {
    private final Logger log = LoggerFactory.getLogger(GroupResource.class);

    private static final String ENTITY_NAME = "group";

    private final GroupService groupService;

    public GroupResource(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    @Timed
    public List<GroupDTO> getAllGroups() {
        log.debug("REST request to get all Groups");
        return groupService.findAll();
    }

    @GetMapping("/groups/{id}")
    @Timed
    public ResponseEntity<GroupDTO> getGroup(@PathVariable Long id) {
        log.debug("REST request to get Group : {}", id);
        Optional<GroupDTO> departmentDTO = groupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(departmentDTO);
    }
}
