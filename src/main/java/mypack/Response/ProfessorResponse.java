package mypack.Response;

import mypack.pojo.Professor;
import java.sql.Date;

public class ProfessorResponse extends Professor{
    private String depName;

    public ProfessorResponse() {
    }

    public ProfessorResponse(long id, String password, String name, Integer teachingAge, String title, String educationBackground, java.sql.Date birthday, String nationality, String areaInterest, int sex, String politicalStatus, String contactInfomation, int depId, String depName) {
        super(id, password, name, teachingAge, title, educationBackground, birthday, nationality, areaInterest, sex, politicalStatus, contactInfomation, depId);
        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }


    @Override
    public String toString() {
        String string="Id:"+getId()+",name:"+getName()+",academy:"+getDepName()+",major:"+getAreaInterest();
        return string;
    }
}
