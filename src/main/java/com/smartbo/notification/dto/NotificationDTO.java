package com.smartbo.notification.dto;

import java.time.LocalDateTime;

import com.smartbo.member.domain.Member;
import com.smartbo.notification.domain.IsReadYn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {

	private Long notificationId;
	private Member member;
	private String message;
	private LocalDateTime createdAt;
	private IsReadYn isReadYn;
	
}
