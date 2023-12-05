package study.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.domain.Region;
import study.repository.RegionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionQueryServiceImpl implements RegionQueryService{

    private final RegionRepository regionRepository;

    @Override
    public Optional<Region> findRegion(Long value) {
        return regionRepository.findById(value);
    }
}
