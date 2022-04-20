package io.jeongjaeeom.spring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import io.jeongjaeeom.spring.domain.Post;
import io.jeongjaeeom.spring.domain.PostRepository;
import io.jeongjaeeom.spring.service.PostCommand.RegisterPost;
import io.jeongjaeeom.spring.service.PostCommand.UpdatePost;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostServiceTest {

  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostService postService;

  @Autowired
  private CommentService commentService;

  @AfterEach
  void tearDown() {
    postRepository.deleteAll();
  }

  @Test
  void register() {
    Long postId = postService.registerPost(new RegisterPost("제목", "내용"));
    assertThat(postId).isNotNull();
  }

  @Test
  void registerWithComment() {
    postService.registerPostWithComment(new RegisterPost("제목", "내용"));
    assertThatThrownBy(() -> postService.registerPostWithComment(new RegisterPost("제목", "내용")))
            .isInstanceOf(RuntimeException.class);
  }

  @Test
  void proxyUpdatePost() {
    Long postId = postService.registerPost(new RegisterPost("제목", "내용"));
    postService.updateProxy(postId, new UpdatePost("제목", "내용수정"));
    Post updatedPost = postRepository.findById(postId).orElseThrow();
    assertThat(updatedPost.getContent()).isEqualTo("내용");
  }
}