package com.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.model.Schedule;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

}
