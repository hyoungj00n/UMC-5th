package study.service.StoreService;

import org.springframework.data.domain.Page;
import study.domain.Review;
import study.domain.Store;

import java.util.Optional;

public interface StoreQueryService {

    public Optional<Store> findStore(Long id);

    public Page<Review> getReviewList(Long StoreId, Integer page);
}