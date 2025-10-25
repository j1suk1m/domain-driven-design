package study.backend.ddd.transactionscript.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import study.backend.ddd.transactionscript.dto.TxPostStatus;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class TxPost {
    private Long id;
    private String title;
    private String content;
    private String author;
    private TxPostStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int viewCount;

    @Builder
    public TxPost(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.status = TxPostStatus.DRAFT;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.viewCount = 0;
    }
}
