package com.cts.pmapps.repo;

import com.cts.pmapps.domain.Project;
import com.cts.pmapps.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
}
