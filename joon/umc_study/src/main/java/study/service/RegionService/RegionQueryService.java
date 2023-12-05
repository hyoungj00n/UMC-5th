package study.service.RegionService;

import study.domain.Region;

import java.util.Optional;

public interface RegionQueryService {

    Optional<Region> findRegion(Long value);



}
