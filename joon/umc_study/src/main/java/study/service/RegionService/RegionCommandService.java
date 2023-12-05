package study.service.RegionService;

import study.domain.Store;
import study.web.dto.RegionRequestDTO;

public interface RegionCommandService {

    public Store createStore(Long regionId,RegionRequestDTO.StoreDTO request);
}
