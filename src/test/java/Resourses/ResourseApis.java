package Resourses;

public enum ResourseApis {
    AddplaceApi("/maps/api/place/add/json"),
    GetplaceApi("/maps/api/place/get/json"),
    DeleteplaceApi("/maps/api/place/delete/json");

    String resoursePath;
    ResourseApis(String resoursePath) {
        this.resoursePath= resoursePath;
    }
    public String getPath()
    {
        return resoursePath;
    }
}
