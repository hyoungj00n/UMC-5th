package study.service.StoreService;

import study.domain.Review;
import study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    public Review createReview(Long storeId, Long memberId, StoreRequestDTO.ReviewDTO request);
}
