package study.service.StoreService;

import study.domain.Mission;
import study.domain.Review;
import study.web.dto.StoreRequestDTO;

public interface StoreCommandService {

    public Review createReview(Long storeId, Long memberId, StoreRequestDTO.ReviewDTO request);

    public Mission createMission(StoreRequestDTO.MissionDTO request,Long storeId);
}
