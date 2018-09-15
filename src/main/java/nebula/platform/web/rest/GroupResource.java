package nebula.platform.web.rest;

import com.codahale.metrics.annotation.Timed;
import nebula.platform.service.GroupService;
import nebula.platform.service.dto.GroupDTO;
import nebula.platform.web.rest.util.PaginationUtil;
import nebula.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<GroupDTO>> findAllGroups(String name,Boolean isSystem, Pageable pageable) {

        Page<GroupDTO> page;

        if (name == null || name.isEmpty() ){
            if(isSystem == null){
                page = groupService.findAll(pageable);
            } else {
                page = groupService.findIsSystem(isSystem,pageable);
            }
        } else {
            if(isSystem == null){
                page = groupService.findByNameIgnoreCaseContaining(name,pageable);
            } else {
                page = groupService.findByNameIgnoreCaseContainingAndIsSystem(name,isSystem,pageable);
            }
        }

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/groups");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    @GetMapping("/groups/{id}")
    @Timed
    public ResponseEntity<GroupDTO> getGroup(@PathVariable Long id) {
        log.debug("REST request to get Group : {}", id);
        Optional<GroupDTO> departmentDTO = groupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(departmentDTO);
    }
}
