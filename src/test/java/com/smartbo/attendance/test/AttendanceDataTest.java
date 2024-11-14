package com.smartbo.attendance.test;

import com.smartbo.attendance.domain.AbsentYn;
import com.smartbo.attendance.domain.Attendance;
import com.smartbo.attendance.repository.AttendanceRepository;
import com.smartbo.member.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
public class AttendanceDataTest {

    @Autowired
    private AttendanceRepository attendanceRepository;

//    @Test
    void generateTestData() {
        Random random = new Random();
        
        IntStream.range(0, 300)
            .forEach(i -> {
                Member member = new Member();
                member.setMemberId((long)(random.nextInt(302) + 1));

                Attendance attendance = new Attendance();
                attendance.setMember(member);
                attendance.setDate(LocalDate.of(2024, 3, random.nextInt(31) + 1));

                if (random.nextFloat() < 0.1) { // 10% 확률로 결근
                    attendance.setAbsentYn(AbsentYn.Y);
                    attendance.setAbsentReason(getRandomReason(random));
                } else {
                    attendance.setAbsentYn(AbsentYn.N);
                    attendance.setCheckInTime(LocalTime.of(9, 0).plusMinutes(random.nextInt(70) - 10));
                    attendance.setCheckOutTime(LocalTime.of(18, 0).plusMinutes(random.nextInt(181)));
                    attendance.setOvertimeHours(random.nextInt(4));
                    attendance.setLateTime(random.nextInt(60));
                }

                attendanceRepository.save(attendance);
            });
    }

    private String getRandomReason(Random random) {
        String[] reasons = {"연차", "병가", "경조사", "개인 사유", "출장"};
        return reasons[random.nextInt(reasons.length)];
    }
}