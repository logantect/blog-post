package io.jeongjaeeom.spring.service;

import static org.junit.jupiter.api.Assertions.*;

import io.jeongjaeeom.spring.domain.PostRepository;
import io.jeongjaeeom.spring.service.PostCommand.RegisterPost;
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

  private PostService postService;

  @BeforeEach
  void setUp() {
    this.postService = new PostService(postRepository);
  }

  @AfterEach
  void tearDown() {
    postRepository.deleteAll();
  }

  @Test
  void proxyPost() {
    postService.proxyPost(new RegisterPost("제목", "내용"));
  }
}