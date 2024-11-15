package com.smartbo.test;

import com.smartbo.member.domain.Member;
import com.smartbo.member.repository.MemberRepository;
import com.smartbo.payroll.domain.Salary;
import com.smartbo.payroll.repository.SalaryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@SpringBootTest
public class SalaryDataTest {
    
    @Autowired
    private SalaryRepository salaryRepository;
    
    @Autowired
    private MemberRepository memberRepository;
    
//    @Test
    public void generateSalaryTestData() {
        Random random = new Random();
        
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(24);
        
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        
        for (int i = 0; i < 500; i++) {
            Long memberId = (long) (random.nextInt(302) + 1);
            Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
            
            BigDecimal baseSalary = new BigDecimal(random.nextInt(45_000_00) + 25_000_00)
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
            
            BigDecimal bonus = new BigDecimal(random.nextInt(20_000_00))
                .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
            
            BigDecimal taxRate = new BigDecimal(random.nextInt(5) + 8)
                .divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP);
            BigDecimal tax = baseSalary.multiply(taxRate)
                .setScale(2, RoundingMode.HALF_UP);
            
            BigDecimal deductionRate = new BigDecimal(random.nextInt(5) + 3)
                .divide(new BigDecimal("100"), 4, RoundingMode.HALF_UP);
            BigDecimal deductions = baseSalary.multiply(deductionRate)
                .setScale(2, RoundingMode.HALF_UP);
            
            BigDecimal totalSalary = baseSalary.add(bonus).subtract(tax).subtract(deductions)
                .setScale(2, RoundingMode.HALF_UP);
            
            long randomDays = random.nextInt((int) daysBetween);
            LocalDate paymentDate = startDate.plusDays(randomDays);
            
            Salary salary = new Salary(
                null,  
                member,
                baseSalary,
                bonus,
                tax,
                deductions,
                totalSalary,
                paymentDate
            );
            
            salaryRepository.save(salary);
        }
    }
}