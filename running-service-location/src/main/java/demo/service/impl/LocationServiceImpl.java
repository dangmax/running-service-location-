package demo.service.impl;

import demo.domain.Location;
import demo.domain.LocationRepository;
import demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> saveRunningLOcations(@RequestParam List<Location> runningLocations) {
        return locationRepository.save(runningLocations);
    }

    @Override
    public void deleteAll() {
        locationRepository.deleteAll();
    }

    @Override
    public Page<Location> findByRunnerMovementType(String movementType, Pageable pageable) {
        return locationRepository.findByRunningMovementType(Location.RunningMovementType.valueOf(movementType),pageable);
    }

    @Override
    public Page<Location> findByRunningId(String runningId, Pageable pageable) {
        return locationRepository.findByUnitInfoRunningId(runningId,pageable);
    }


}
