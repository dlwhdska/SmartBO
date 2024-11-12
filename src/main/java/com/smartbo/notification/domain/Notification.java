package com.smartbo.notification.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.smartbo.member.domain.Member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Notification {

	// 알림 고유 ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notification_id")
	private Long notificationId;
	
	// 직원 고유 ID
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;
	
	// 알림 메시지
	@Column(nullable = false, columnDefinition = "TEXT")
	private String message;
	
	// 생성일
	@Column(name = "created_at", nullable = false)
	@CreationTimestamp // 기본값이 CURRENT_TIMESTAMP로 설정됨
	private LocalDateTime createdAt;
	
	// 읽음 여부 (사용자가 알림을 열거나 클릭하면 n -> y로)
	@Enumerated(EnumType.STRING)
	@Column(name = "is_read_yn", nullable = false, columnDefinition = "ENUM('Y', 'N') DEFAULT 'N'")
	private IsReadYn isReadYn;
	
}
