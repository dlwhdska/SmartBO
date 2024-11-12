package com.smartbo.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartbo.attendance.domain.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
