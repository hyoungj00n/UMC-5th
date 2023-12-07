package study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.converter.ReviewConverter;
import study.domain.Review;
import study.repository.MemberRepository;
import study.repository.ReviewRepository;
import study.repository.StoreRepository;
import study.web.dto.StoreRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    private final ReviewRepository reviewRepository;

    private final MemberRepository memberRepository;

    @Override
    public Review createReview(Long storeId, Long memberId, StoreRequestDTO.ReviewDTO request) {

        Review review  = ReviewConverter.toReview(request);
        review.setStore(storeRepository.findById(storeId).get());
        review.setMember(memberRepository.findById(memberId).get());

        return reviewRepository.save(review);

    }
}
