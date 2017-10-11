package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.PersistentIdentifierGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
//    @GeneratedValue(generator = "CusGenerator")
//    @GenericGenerator(name = "CusGenerator",strategy = "assigned")
    private int heartRate = 0;
    private Date timestamp = new Date();

    @Id
    @GeneratedValue
    private long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "userinfo_username")),
            @AttributeOverride(name = "address", column = @Column(name = "userinfo_address"))
    })
    private UserInfo userInfo;

//    @org.springframework.data.annotation.Transient
//    private long userId;
//    @org.springframework.data.annotation.Transient
//    private String healthWarningLevel;

    public RunningInformation() {
    }

    public RunningInformation(UserInfo userInfo){
        this.userInfo =  userInfo;
    }

}

//class CusGenerator implements PersistentIdentifierGenerator{
//
//    @Override
//    public String[] sqlCreateStrings(Dialect dialect) throws HibernateException {
//        return new String[0];
//    }
//
//    @Override
//    public String[] sqlDropStrings(Dialect dialect) throws HibernateException {
//        return new String[0];
//    }
//
//    @Override
//    public Object generatorKey() {
//        Random random = new Random();
//        int heartRate = random.nextInt((200-60)+1)+60;
//        return heartRate;
//    }
//
//    @Override
//    public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
//        return null;
//    }
//}