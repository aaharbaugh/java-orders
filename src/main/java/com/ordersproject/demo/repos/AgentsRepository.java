package com.ordersproject.demo.repos;

import com.ordersproject.demo.model.Agents;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agents, Long> {
}
