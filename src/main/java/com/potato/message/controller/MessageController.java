package com.potato.message.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.potato.message.service.MessageService;
import com.potato.message.vo.MessageVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@Tag(name = "익명 메시지 전송 API", description = "컨트롤러에 대한 설명입니다.")
@RequestMapping("/message")
public class MessageController {
	
	private final MessageService messageService;
	
	@Operation(summary = "메시지 전송하기", description = "클라이언트에게 받은 메시지 데이터 및 ip 정보 DB 저장")
	@PostMapping("/api/v1/send")
	public ResponseEntity<String> sendMessage(@RequestBody String sendMessage, HttpServletRequest request) {
		String clientIp = getClientIp(request);
		
		MessageVO messageVO = new MessageVO();
		messageVO.setMsgSenderIp(clientIp);
		messageVO.setMsgContent(sendMessage);
		messageService.insertMessage(messageVO);
		
		return ResponseEntity.ok(clientIp);
	}
	
	@Operation(summary = "클라이언트 IP 정보 호출", description = "클라이언트 IP 정보 호출 후 데이터 Return")
	public static String getClientIp(HttpServletRequest request) {

        String clientIp = request.getHeader("X-Forwarded-For");
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (clientIp  == null || clientIp .length() == 0 || "unknown".equalsIgnoreCase(clientIp )) {
            clientIp  = request.getHeader("X-Real-IP");
        }
        if (clientIp  == null || clientIp .length() == 0 || "unknown".equalsIgnoreCase(clientIp )) {
            clientIp  = request.getHeader("X-RealIP");
        }
        if (clientIp  == null || clientIp .length() == 0 || "unknown".equalsIgnoreCase(clientIp )) {
            clientIp  = request.getHeader("REMOTE_ADDR");
        }
        if (clientIp == null || clientIp.length() == 0 || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr();
        }
       
        return clientIp; 

	}

}
