package pageobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import pageobject.categorydetails;
import pageobject.tagdetails;
import io.cucumber.datatable.DataTable;

public class petdetails {
    private String strId;
    private String strName, strStatus;
    private List<tagdetails> arrTagDetails = new ArrayList<>();
    private String[] strPhoto_Url;
    private categorydetails objCategoryDetails;

    public petdetails(DataTable dtPetDetails){
        List<Map<String,String>> petDetails = dtPetDetails.asMaps(String.class,String.class);
        this.strId = petDetails.get(0).get("Id");
        this.strName = petDetails.get(0).get("Name");
        this.strStatus = petDetails.get(0).get("Status");
        this.strPhoto_Url = petDetails.get(0).get("Photo_Url").split(";");

        //Creating array of tagDetails object.
        for (int iCountTagsId =0; iCountTagsId < petDetails.get(0).get("Tags_Id").split(";").length;iCountTagsId++){
        	tagdetails tagDetailsObj = new tagdetails((petDetails.get(0).get("Tags_Id").split(";"))[iCountTagsId],
                    (petDetails.get(0).get("Tags_Name").split(";")[iCountTagsId]));
            this.arrTagDetails.add(tagDetailsObj);
        }

        this.objCategoryDetails =new categorydetails(petDetails.get(0).get("Category_Id"),petDetails.get(0).get("Category_Name"));
    }

    public petdetails() {
        super();
    }

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrStatus() {
        return strStatus;
    }

    public void setStrStatus(String strStatus) {
        this.strStatus = strStatus;
    }

    public String[] getStrPhoto_Url() {
        return strPhoto_Url;
    }

    public void setStrPhoto_Url(String[] strPhoto_Url) {
        this.strPhoto_Url = strPhoto_Url;
    }

    public List<tagdetails> getArrTagDetails() {
        return arrTagDetails;
    }

    public void setArrTagDetails(List<tagdetails> arrTagDetails) {
        this.arrTagDetails = arrTagDetails;
    }

    public categorydetails getObjCategoryDetails() {
        return objCategoryDetails;
    }

    public void setObjCategoryDetails(categorydetails objCategoryDetails) {
        this.objCategoryDetails = objCategoryDetails;
    }
}

