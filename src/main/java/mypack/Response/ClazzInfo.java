package mypack.Response;

import mypack.pojo.Clazz;

public class ClazzInfo extends Clazz {
    private String depName;
    private String proName;

    public ClazzInfo() {
    }

    public ClazzInfo(long id, String name, int quantity, int majID, Long proId, int year, String depName, String proName) {
        super(id, name, quantity, majID, proId, year);
        this.depName = depName;
        this.proName = proName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Override
    public String toString() {
        return "year:"+getYear()+",depName:"+getDepName()+",id:"+getId()+",name:"+getName()+",proName:"+getProName()+",quantity:"+getQuantity();
    }

    public String toString2() {
        return "grade:"+getYear()+",academy:"+getDepName()+",aclass:"+getName();
    }
}

