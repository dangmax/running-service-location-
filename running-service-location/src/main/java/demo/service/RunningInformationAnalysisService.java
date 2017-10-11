package demo.service;

import demo.domain.RunningInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationAnalysisService {

    List<RunningInformation> saveRunningInformations(List<RunningInformation> runningInformations);

    int deleteByRunningId(String runningId);

    Page<RunningInformation> findByPage(Pageable pageable);

//    Page<Location> findByRunnerMovementType(String movementType, Pageable pageable);
//    Page<Location> findByRunningId(String runningId, Pageable pageable);


}
