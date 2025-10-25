package study.backend.ddd.transactionscript;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.backend.ddd.transactionscript.domain.TxPost;
import study.backend.ddd.transactionscript.dto.TxPostStatus;
import study.backend.ddd.transactionscript.repository.TxPostRepository;
import study.backend.ddd.transactionscript.service.TxBlogService;

public class TxApplicationTests {
    TxBlogService blogService;

    @BeforeEach
    void init() {
        blogService = new TxBlogService(new TxPostRepository());
    }

    @Test
    void 게시글을_생성한다() {
        // given
        String targetTitle = "게시글 제목";
        String targetContent = "게시글 내용";
        String targetAuthor = "게시글 작성자";

        // when
        TxPost createdPost = blogService.createPost(targetTitle, targetContent, targetAuthor);

        // then
        Assertions.assertNotNull(createdPost.getId());
        Assertions.assertEquals(TxPostStatus.DRAFT, createdPost.getStatus());
        Assertions.assertEquals(targetTitle, createdPost.getTitle());
        Assertions.assertEquals(targetContent, createdPost.getContent());
        Assertions.assertEquals(targetAuthor, createdPost.getAuthor());
    }
}
