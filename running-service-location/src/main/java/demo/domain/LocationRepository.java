package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location,Long>{

    Page<Location> findByRunningMovementType(@Param("movementType") Location.RunningMovementType movementType,  Pageable pageable);

    Page<Location> findByUnitInfoRunningId(@Param("runningId") String runningId,Pageable pageable);



}
