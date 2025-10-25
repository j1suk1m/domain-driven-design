package study.backend.ddd.transactionscript.repository;

import study.backend.ddd.transactionscript.domain.TxPost;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public Optional<TxPost> findById(Long id) {
        return existsById(id)
            ? Optional.of(db.get(id))
            : Optional.empty();
    }

    public boolean existsById(Long id) {
        return db.containsKey(id);
    }

    public List<TxPost> findAll() {
        return db.values()
            .stream()
            .toList();
    }
}
