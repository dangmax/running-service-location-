package demo.service.impl;

import demo.domain.RunningInfoRepository;
import demo.domain.RunningInformation;
import demo.service.RunningInformationAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Service
public class RunningInformationAnalysisServiceImpl implements RunningInformationAnalysisService{

    private RunningInfoRepository runningInfoRepository;

    @Autowired
    public RunningInformationAnalysisServiceImpl(RunningInfoRepository runningInfoRepository) {
        this.runningInfoRepository = runningInfoRepository;
    }

    @Override
    public List<RunningInformation> saveRunningInformations(@RequestParam List<RunningInformation> runningInformations) {
        //generate random heartRate
        for(RunningInformation runningInformation:runningInformations){
            Random random = new Random();
            int heartRate = random.nextInt((200-60)+1)+60;
            runningInformation.setHeartRate(heartRate);
        }
        return runningInfoRepository.save(runningInformations);
    }

    @Override
    public int deleteByRunningId(@RequestParam String runningId) {
       return runningInfoRepository.deleteByRunningId(runningId);
    }

    @Override
    public Page<RunningInformation> findByPage(Pageable pageable) {
        return runningInfoRepository.findAllByHeartRateIsNotNullOrderByHeartRateDesc(pageable);
    }
}
