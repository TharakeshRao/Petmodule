package pageobject;

public class tagdetails  {
    private String strTagId,strTagName;

    public tagdetails(String strTagId,String strTagName){
        this.strTagId = strTagId;
        this.strTagName = strTagName;
    }

    public tagdetails(){
            super();
    }

    public String getStrTagId() {
        return strTagId;
    }

    public void setStrTagId(String strTagId) {
        this.strTagId = strTagId;
    }

    public String getStrTagName() {
        return strTagName;
    }

    public void setStrTagName(String strTagName) {
        this.strTagName = strTagName;
    }

}
