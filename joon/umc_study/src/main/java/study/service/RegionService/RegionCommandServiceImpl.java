package study.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.converter.RegionConverter;
import study.domain.Store;
import study.repository.RegionRepository;
import study.repository.StoreRepository;
import study.web.dto.RegionRequestDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class RegionCommandServiceImpl implements RegionCommandService{

    private final StoreRepository storeRepository;

    private final RegionRepository regionRepository;

    @Override
    public Store createStore(Long regionId, RegionRequestDTO.StoreDTO request){

        Store store = RegionConverter.toStore(request);
        store.setRegion(regionRepository.findById(regionId).get());

        return storeRepository.save(store);
    }
}
