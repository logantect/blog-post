package io.jeongjaeeom.spring.service;

import io.jeongjaeeom.spring.domain.Post;
import io.jeongjaeeom.spring.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

  private final PostRepository postRepository;

  public void proxyPost(PostCommand.RegisterPost command) {
    registerPost(command);
  }

  @Transactional
  void registerPost(PostCommand.RegisterPost command) {
    Post savedPost = postRepository.save(command.toEntity());
    savedPost.changeContent("제목수정");  // Dirty Checking 작동 안함.
  }

}