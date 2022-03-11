package io.jeongjaeeom.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "post")
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "content")
  private String content;

  public Post() {
  }

  @Builder
  public Post(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public void changeContent(String content) {
    this.content = content;
  }
}
