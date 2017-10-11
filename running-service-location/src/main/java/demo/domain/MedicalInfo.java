package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicalInfo {
    private Long bfr;
    private Long fmi;

    public MedicalInfo() {
    }

    public MedicalInfo(Long bfr, Long fmi) {
        this.bfr = bfr;
        this.fmi = fmi;
    }

//    public Long getBfr() {
//        return bfr;
//    }
//
//    public void setBfr(Long bfr) {
//        this.bfr = bfr;
//    }
//
//    public Long getFmi() {
//        return fmi;
//    }
//
//    public void setFmi(Long fmi) {
//        this.fmi = fmi;
//    }
}
