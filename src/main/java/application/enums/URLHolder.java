package application.enums;

public enum URLHolder {
    LOGIN_PAGE ("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/"),
    USER_START_PAGE("http://prestashop-automation.qatestlab.com.ua/ru/");

    private String URL;

    URLHolder(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
