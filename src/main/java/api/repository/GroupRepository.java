package api.repository;

import api.model.Group;
import api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("select group from Group group where group.namr = :groupName")
    Group findByName(@Param("groupName") String groupName);
}
