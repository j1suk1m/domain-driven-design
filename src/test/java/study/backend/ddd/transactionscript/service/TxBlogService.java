package study.backend.ddd.transactionscript.service;

import lombok.RequiredArgsConstructor;
import study.backend.ddd.transactionscript.domain.TxPost;
import study.backend.ddd.transactionscript.dto.TxPostStatus;
import study.backend.ddd.transactionscript.repository.TxPostRepository;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class TxBlogService {
    private final TxPostRepository postRepository;

    public TxPost createPost(String title, String content, String author) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("제목을 입력해주세요.");
        }

        if (content == null || content.trim().isEmpty()) {
            throw new IllegalArgumentException("내용을 입력해주세요.");
        }

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("작성자를 입력해주세요.");
        }

        TxPost post = TxPost.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();

        return postRepository.save(post);
    }

    public TxPost getPostById(Long id) {
        TxPost post = postRepository.findById(id)
            .orElseThrow(NoSuchElementException::new);

        post.setViewCount(post.getViewCount() + 1);

        return postRepository.save(post);
    }

    public void publishPost(Long id) {
        TxPost post = postRepository.findById(id)
            .orElseThrow(NoSuchElementException::new);

        if (post.getStatus() != TxPostStatus.DRAFT) {
            throw new IllegalStateException("초안 상태의 게시글만 발행할 수 있습니다.");
        }

        post.setStatus(TxPostStatus.PUBLISHED);
        post.setUpdatedAt(LocalDateTime.now());

        postRepository.save(post);
    }
}
