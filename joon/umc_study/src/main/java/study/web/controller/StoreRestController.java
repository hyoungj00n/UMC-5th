package study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.base.ApiResponse;
import study.config.StoreSchema;
import study.converter.MissionConverter;
import study.converter.ReviewConverter;
import study.converter.StoreConverter;
import study.domain.Mission;
import study.domain.Review;
import study.repository.StoreRepository;
import study.service.StoreService.StoreCommandService;
import study.service.StoreService.StoreQueryService;
import study.validation.annotation.ExistMember;
import study.validation.annotation.ExistStore;
import study.web.dto.StoreRequestDTO;
import study.web.dto.StoreResponseDTO;

import javax.validation.constraints.Positive;

@RestController
@RequiredArgsConstructor
@Validated
@Tag(name = "Store",description = "상점")
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    private final StoreQueryService storeQueryService;


    @PostMapping("/{storeId}/review/{memberId}")
    public ApiResponse<StoreResponseDTO.CreateReviewResultDTO> createReview(@RequestBody StoreRequestDTO.ReviewDTO request,
                                                                            @ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                            @ExistMember @PathVariable(name = "memberId") Long memberId
    ){
        Review review = storeCommandService.createReview(storeId,memberId,request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateReviewResult(review));
    }

    @PostMapping("/{storeId}/mission")
    public ApiResponse<StoreResponseDTO.CreateMissionResultDTO> createMission(@RequestBody StoreRequestDTO.MissionDTO request,
                                                                              @ExistStore @PathVariable(name = "storeId") Long storeId){
        Mission mission = storeCommandService.createMission(request,storeId);
        return ApiResponse.onSuccess(MissionConverter.toCreateMissionResult(mission));
    }

    @GetMapping("/{storeId}/reviews")
    @Positive(message = "상점의 값은 양수이다.")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 가게의 리뷰들의 목록을 조회, 페이징 포함, query String으로 page 번호 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = StoreSchema.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호입니다. 0번이 1번 페이지입니다."),
            @Parameter(schema = @Schema(implementation = StoreSchema.class))

    })
    public ApiResponse<StoreResponseDTO.ReviewPreviewListDTO> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId,
                                                                                @RequestParam(name = "page") Integer page){
        Page<Review> reviewList= storeQueryService.getReviewList(storeId, page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreviewListDTO(reviewList));
    }
}
