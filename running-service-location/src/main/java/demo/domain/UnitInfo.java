package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnitInfo {

    public UnitInfo(String runningId, String bandMake, String customerName, String unitNumber) {
        this.runningId = runningId;
        this.bandMake = bandMake;
        this.customerName = customerName;
        this.unitNumber = unitNumber;
    }

    public UnitInfo(){
        this.runningId="";
    }

    public UnitInfo(String runningId) {
        this.runningId = runningId;
    }

    private final String runningId;
    private String bandMake;
    private String customerName;
    private String unitNumber;

//    public void setBandMake(String bandMake) {
//        this.bandMake = bandMake;
//    }
//
//    public void setCustomerName(String customerName) {
//        this.customerName = customerName;
//    }
//
//    public void setUnitNumber(String unitNumber) {
//        this.unitNumber = unitNumber;
//    }
//
//    public String getRunningId() {
//
//        return runningId;
//    }
//
//    public String getBandMake() {
//        return bandMake;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public String getUnitNumber() {
//        return unitNumber;
//    }


}
