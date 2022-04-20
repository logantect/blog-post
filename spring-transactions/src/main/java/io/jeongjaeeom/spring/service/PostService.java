package io.jeongjaeeom.spring.service;

import io.jeongjaeeom.spring.domain.Post;
import io.jeongjaeeom.spring.domain.PostRepository;
import io.jeongjaeeom.spring.service.PostCommand.UpdatePost;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {

  private final PostRepository postRepository;
  private final CommentService commentService;

  @Transactional(readOnly = true)
  public Long registerPost(PostCommand.RegisterPost command) {
    Post savedPost = postRepository.save(command.toEntity());
    return savedPost.getId();
  }

  public Long registerPostWithComment(PostCommand.RegisterPost command) {
    Post savedPost = postRepository.save(command.toEntity());
    commentService.register("sdfrsdf");
    return savedPost.getId();
  }

  public void updateProxy(final Long postId, PostCommand.UpdatePost command) {
    updatePost(postId, command);
  }

  @Transactional
  void updatePost(final Long postId, UpdatePost command) {
    Post post = postRepository.findById(postId).orElseThrow();
    post.changeContent(command.getContent()); // Not Dirty Checking
  }


}