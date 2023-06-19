package com.dronmed.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryEventRepository extends JpaRepository<HistoryEvent, Long> {
}
