package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "LOCATION")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    enum GpsStatus{
        EXCELLENT,OK,UNRELIABLE,BAD,NOFIX,UNKNOWN;
    }

    public enum RunningMovementType{
        STOPPED,IN_MOTION;

        public boolean isMoving(){
         return this!= STOPPED;
        }
    }

    @Id
    @GeneratedValue
    private long id;
    private double latitude;
    private double longitude;
    private String heading;
    private double gpsSpeed;
    private GpsStatus gpsStatus;
    private double odometer;
    private double totalRunningTime;
    private double totalidleTime;
    private double totalCalorieBurnt;
    private String address;
    private Date timestamp = new Date();
    private String gearProvidor;
    private RunningMovementType runningMovementType = RunningMovementType.STOPPED;
    private String serviceType;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bandMake",column = @Column(name = "unit_bandMake")),
            @AttributeOverride(name = "customerName",column = @Column(name = "unit_customerName"))
    })
    private UnitInfo unitInfo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "bfr",column = @Column(name = "medical_bfr")),
            @AttributeOverride(name = "fmi",column = @Column(name = "medical_fmi"))
    })
    private MedicalInfo medicalInfo;


    public Location(){
        this.unitInfo=null;
    }

    @JsonCreator()
    public Location(@JsonProperty("runningId")  String runningId){
        this.unitInfo= new UnitInfo(runningId);
    }

    public Location(UnitInfo unitInfo) {
        this.unitInfo = unitInfo;
    }

    public String getRunningId(){
        return this.unitInfo == null?null:this.unitInfo.getRunningId();
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(double latitude) {
//        this.latitude = latitude;
//    }
//
//    public double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(double longitude) {
//        this.longitude = longitude;
//    }
//
//    public String getHeading() {
//        return heading;
//    }
//
//    public void setHeading(String heading) {
//        this.heading = heading;
//    }
//
//    public double getGpsSpeed() {
//        return gpsSpeed;
//    }
//
//    public void setGpsSpeed(double gpsSpeed) {
//        this.gpsSpeed = gpsSpeed;
//    }
//
//    public GpsStatus getGpsStatus() {
//        return gpsStatus;
//    }
//
//    public void setGpsStatus(GpsStatus gpsStatus) {
//        this.gpsStatus = gpsStatus;
//    }
//
//    public double getOdometer() {
//        return odometer;
//    }
//
//    public void setOdometer(double odometer) {
//        this.odometer = odometer;
//    }
//
//    public double getTotalRunningTime() {
//        return totalRunningTime;
//    }
//
//    public void setTotalRunningTime(double totalRunningTime) {
//        this.totalRunningTime = totalRunningTime;
//    }
//
//    public double getTotalidleTime() {
//        return totalidleTime;
//    }
//
//    public void setTotalidleTime(double totalidleTime) {
//        this.totalidleTime = totalidleTime;
//    }
//
//    public double getTotalCalorieBurnt() {
//        return totalCalorieBurnt;
//    }
//
//    public void setTotalCalorieBurnt(double totalCalorieBurnt) {
//        this.totalCalorieBurnt = totalCalorieBurnt;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public Date getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(Date timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public String getGearProvidor() {
//        return gearProvidor;
//    }
//
//    public void setGearProvidor(String gearProvidor) {
//        this.gearProvidor = gearProvidor;
//    }
//
//    public RunningMovementType getRunningMovementType() {
//        return runningMovementType;
//    }
//
//    public void setRunningMovementType(RunningMovementType runningMovementType) {
//        this.runningMovementType = runningMovementType;
//    }
//
//    public String getServiceType() {
//        return serviceType;
//    }
//
//    public void setServiceType(String serviceType) {
//        this.serviceType = serviceType;
//    }
//
//    public UnitInfo getUnitInfo() {
//        return unitInfo;
//    }
//
//    public void setUnitInfo(UnitInfo unitInfo) {
//        this.unitInfo = unitInfo;
//    }
}
