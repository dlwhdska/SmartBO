package com.smartbo.performance.domain;

import com.smartbo.member.domain.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceReview {

	// 인사 평가 고유 ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Long reviewId;
	
	// 직원 고유 ID
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	// 평가 주기
	@Column(name = "review_period", nullable = false, length = 50)
	private String reviewPeriod;
	
	// 평가 점수
	@Column(nullable = false)
	private int score;
	
	// 내용, 코멘트
	@Column(nullable = false, columnDefinition = "TEXT")
	private String comment;
	
}
