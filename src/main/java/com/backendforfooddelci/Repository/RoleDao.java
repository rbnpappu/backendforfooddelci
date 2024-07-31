package com.backendforfooddelci.Repository;




import org.springframework.data.repository.CrudRepository;

import com.backendforfooddelci.Entity.RegisterUserRole;
;

public interface RoleDao extends CrudRepository<RegisterUserRole, Long> {

}
