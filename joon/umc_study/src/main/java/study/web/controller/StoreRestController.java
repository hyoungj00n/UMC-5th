package study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.base.ApiResponse;
import study.converter.ReviewConverter;
import study.domain.Review;
import study.repository.StoreRepository;
import study.service.StoreService.StoreCommandService;
import study.web.dto.StoreRequestDTO;
import study.web.dto.StoreResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{storeId}/review/{memberId}")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody StoreRequestDTO.ReviewDTO request,
                                                                            @PathVariable(name = "storeId") Long storeId,
                                                                            @PathVariable(name = "memberId") Long memberId
    ){
        Review review = storeCommandService.createReview(storeId,memberId,request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResult(review));
    }
}
