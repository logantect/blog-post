package io.jeongjaeeom.spring.interfaces;

import io.jeongjaeeom.spring.domain.Post;
import io.jeongjaeeom.spring.service.PostCommand;
import lombok.Getter;

public class PostDto {

  @Getter
  public static class RegisterPost {
    private String title;

    private String content;

    public RegisterPost(String title, String content) {
      this.title = title;
      this.content = content;
    }

    public PostCommand.RegisterPost toCommand() {
      return new PostCommand.RegisterPost(this.title, this.content);
    }

  }

}
