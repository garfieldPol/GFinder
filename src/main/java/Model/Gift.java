package Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Gift {

    @Id
    @GeneratedValue


//    @Column(name = "id")
    private int id;
//    @Column(name = "giftName")
    private String giftName;
//    @Column(name = "ageGroup")
    private int ageGroup;

    public Gift(int id, String giftName, int ageGroup) {
        this.id = id;
        this.giftName = giftName;
        this.ageGroup = ageGroup;
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
        return "gift{" +
                "giftName='" + giftName + '\'' +
                '}';
    }


}
