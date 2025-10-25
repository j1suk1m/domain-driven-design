package study.backend.ddd.transactionscript.repository;

import study.backend.ddd.transactionscript.domain.TxPost;

import java.util.HashMap;
import java.util.Map;

public class TxPostRepository {
    private final Map<Long, TxPost> db = new HashMap<>();
    private Long sequence = 0L;

    public TxPost save(TxPost post) {
        if (post.getId() == null) {
            post.setId(++sequence);
        }

        db.put(post.getId(), post);

        return post;
    }
}
