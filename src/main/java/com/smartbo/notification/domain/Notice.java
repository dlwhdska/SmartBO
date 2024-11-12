package com.smartbo.notification.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
	
	// 공지사항 고유 ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notice_id")
	private Long noticeId;
	
	// 공지 제목
	@Column(nullable = false, length = 100)
	private String title;
	
	// 공지 내용
	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;
	
	// 작성일
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp // 기본값이 CURRENT_TIMESTAMP로 설정됨
	private LocalDateTime createdAt;
	
	// 부서
	@Column(nullable = false, length = 50)
	private String department;
	
}
