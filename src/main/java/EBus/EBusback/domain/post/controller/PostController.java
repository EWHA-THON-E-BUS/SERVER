package EBus.EBusback.domain.post.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import EBus.EBusback.domain.post.dto.PostRequestDto;
import EBus.EBusback.domain.post.dto.PostResponseDto;
import EBus.EBusback.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;

	@PostMapping("/suggestion")
	@ResponseStatus(HttpStatus.CREATED)
	public PostResponseDto createSuggestion(@RequestBody PostRequestDto requestDto) {
		return postService.createPost(requestDto, true);
	}
}
