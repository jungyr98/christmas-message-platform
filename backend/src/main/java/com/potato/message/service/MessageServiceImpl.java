package com.potato.message.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.potato.core.entity.Message;
import com.potato.message.repository.MessageRepository;
import com.potato.message.vo.MessageVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
	
	private final MessageRepository messageRepository;
	
	@Override
	public void insertMessage(MessageVO messageVO) {
		Message entity = new Message();
		entity.setMsgSenderIp(messageVO.getMsgSenderIp());
		entity.setMsgContent(messageVO.getMsgContent());
		entity.setMsgRegDate(Timestamp.valueOf(LocalDateTime.now()));
		messageRepository.save(entity);
	}

}
