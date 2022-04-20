package io.jeongjaeeom.spring.service;

import io.jeongjaeeom.spring.domain.Comment;
import io.jeongjaeeom.spring.domain.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Long register(String content) {
        Comment comment = new Comment(content);
        Comment save = commentRepository.save(comment);
        return save.getId();
    }

}
