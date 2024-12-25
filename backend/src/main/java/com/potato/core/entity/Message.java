package com.potato.core.entity;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="message")
@Schema(description="메시지 테이블")
@Data
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description="메시지 번호")
	@Column(name="msg_no", nullable=false)
	private int msgNo;
	
	@Schema(description="메시지 내용", nullable=false)
	@Column(name="msg_content")
	private String msgContent;
	
	@Schema(description="전송자 IP")
	@Column(name="msg_sender_ip")
	private String msgSenderIp;
	
	@Schema(description="전송 날짜")
	@Column(name="msg_reg_date", nullable=false)
	private Date msgRegDate;

}
