package study.converter;

import study.domain.Store;
import study.web.dto.RegionRequestDTO;
import study.web.dto.RegionResponseDTO;

import java.time.LocalDateTime;

public class RegionConverter {

    public static Store toStore(RegionRequestDTO.StoreDTO request){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .build();
    }

    public static RegionResponseDTO.CreateStoreResultDTO toCreateStoreResultDTO(Store store){
        return RegionResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
