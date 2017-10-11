package demo.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import demo.domain.RunningInformation;
import demo.service.RunningInformationAnalysisService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/runningInfo")
public class RunningAnalysisRestController {

    @Autowired
    private RunningInformationAnalysisService runningInformationAnalysisService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInformation> runningInformations) {
        runningInformationAnalysisService.saveRunningInformations(runningInformations);
    }

    @RequestMapping(value = "/{runningId}", method = RequestMethod.DELETE)
    public void purge(@PathVariable String runningId) {
        int count = this.runningInformationAnalysisService.deleteByRunningId(runningId);
        System.out.print(count == 1 ? "del 1 item success!" : "del failure!");
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public List<RunningInformationTemp> findOrderByHeartRate(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        Page<RunningInformation> runningInformations = this.runningInformationAnalysisService.findByPage(new PageRequest(page, size));
        List<RunningInformationTemp> out = new ArrayList<RunningInformationTemp>(runningInformations.getSize());

        for (RunningInformation runningInformation : runningInformations.getContent()) {
            RunningInformationTemp runningInformationTemp = new RunningInformationTemp();
            runningInformationTemp.setRunningId(runningInformation.getRunningId());
            runningInformationTemp.setTotalRunningTime(runningInformation.getTotalRunningTime());
            runningInformationTemp.setHeartRate(runningInformation.getHeartRate());
            runningInformationTemp.setUserId(runningInformation.getId());
            runningInformationTemp.setUserName(runningInformation.getUserInfo().getUsername());
            runningInformationTemp.setUserAdress(runningInformation.getUserInfo().getAddress());
            int heartRate = runningInformation.getHeartRate();
            if (heartRate >= 60 && heartRate <= 75) {
                runningInformationTemp.setHealthWarningLevel("LOW");
            } else if (heartRate > 75 && heartRate <= 120) {
                runningInformationTemp.setHealthWarningLevel("NORMAL");
            } else if (heartRate > 120) {
                runningInformationTemp.setHealthWarningLevel("HIGH");
            }
            out.add(runningInformationTemp);
        }
        return out;
    }

}

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
class RunningInformationTemp {
    private String runningId;
    private double totalRunningTime;
    private int heartRate;
    private long userId;
    private String userName;
    private String userAdress;
    private String healthWarningLevel;

    public RunningInformationTemp() {
    }
}