package study.backend.ddd.transactionscript.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class TxComment {
    private Long id;
    private Long postId;
    private String author;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder
    public TxComment(Long postId, String author, String content) {
        this.postId = postId;
        this.author = author;
        this.content = content;
    }
}
