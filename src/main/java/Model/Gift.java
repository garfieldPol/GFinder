package Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gift")
public class Gift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String giftName;
    private int ageGroup;
    @Enumerated(EnumType.STRING)
    Gender gender;

    public Gift(int id,
                String giftName,
                int ageGroup,
                Gender gender
    ) {
        this.id = id;
        this.giftName = giftName;
        this.ageGroup = ageGroup;
        this.gender = gender;
    }

    public Gift() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiftName() {
        return giftName;
    }

    public void setGiftName(String giftName) {
        this.giftName = giftName;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }




    @Override
    public String toString() {
        return "Gift{" +
                "giftName='" + giftName + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
