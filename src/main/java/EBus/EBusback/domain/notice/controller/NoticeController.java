package EBus.EBusback.domain.notice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import EBus.EBusback.domain.notice.dto.NoticeResponseDto;
import EBus.EBusback.domain.notice.service.NoticeService;
import EBus.EBusback.domain.post.dto.PostRequestDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notices")
public class NoticeController {

	private final NoticeService noticeService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public NoticeResponseDto createNotice(@RequestBody PostRequestDto requestDto) {
		return noticeService.createNotice(requestDto);
	}
}
