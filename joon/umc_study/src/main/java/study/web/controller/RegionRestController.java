package study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.base.ApiResponse;
import study.converter.RegionConverter;
import study.domain.Store;
import study.service.RegionService.RegionCommandService;
import study.web.dto.RegionRequestDTO;
import study.web.dto.RegionResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/regions")
public class RegionRestController {

    private final RegionCommandService regionCommandService;

    @PostMapping("/{regionId}/store")
    public ApiResponse<RegionResponseDTO.CreateStoreResultDTO> createStore(@RequestBody RegionRequestDTO.StoreDTO request,
                                                                            @PathVariable(name ="regionId") Long regionId){
        Store store = regionCommandService.createStore(regionId,request);
        return ApiResponse.onSuccess(RegionConverter.toCreateStoreResultDTO(store));

    }
}
