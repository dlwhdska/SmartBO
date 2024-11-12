package com.smartbo.notification.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoiceDTO {
	
	private Long noticeId;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private String department;
	
}
