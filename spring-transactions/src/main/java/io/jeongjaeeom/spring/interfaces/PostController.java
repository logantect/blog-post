package io.jeongjaeeom.spring.interfaces;

import io.jeongjaeeom.spring.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/posts")
public class PostController {

  private final PostService postService;

  @PostMapping
  public ResponseEntity<?> registerPost(@RequestBody PostDto.RegisterPost dto) {
    postService.proxyPost(dto.toCommand());
    return ResponseEntity.ok("ok");
  }


}
