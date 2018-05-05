package sample.Classes;

public class BaseClass {
    private Main appInstance = null;

    public Main getApplicationInstance() {
        return appInstance;
    }

    public void setApplicationInstance(Main applicationInstance) {
        appInstance = applicationInstance;
    }

}
