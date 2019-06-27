package com.cts.pmapps.repo;

import com.cts.pmapps.domain.Task;
import com.cts.pmapps.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task,Integer> {
}
