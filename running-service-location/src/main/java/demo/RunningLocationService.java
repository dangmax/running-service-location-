package demo;

import demo.domain.UnitInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunningLocationService {
    public static void main(String[] args){
        SpringApplication.run(RunningLocationService.class);
        UnitInfo unitInfo = new UnitInfo();
        unitInfo.setCustomerName("dang");
    }

}
