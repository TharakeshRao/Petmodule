package pageobject;

public class categorydetails {
    private String CategoryId,CategoryName;

    public categorydetails(String CategoryId,String CategoryName){
        this.CategoryId=CategoryId;
        this.CategoryName=CategoryName;
    }

    public categorydetails(){
        super();
    }

    public String getStrCategoryId() {
        return CategoryId;
    }

    public void setStrCategoryId(String CategoryId) {
        this.CategoryId = CategoryId;
    }

    public String getStrCategoryName() {
        return CategoryName;
    }

    public void setStrCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }
}
