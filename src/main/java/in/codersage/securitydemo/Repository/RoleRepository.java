package in.codersage.securitydemo.Repository;

import in.codersage.securitydemo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
