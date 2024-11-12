package com.smartbo.performance.dto;

import com.smartbo.member.domain.Member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerformanceReviewDTO {

	private Long reviewId;
	private Member member;
	private String reviewPeriod;
	private int score;
	private String comment;
	
}
