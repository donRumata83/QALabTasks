package Pages;

public enum URLHolder {
    LOGIN_PAGE ("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/"),
    MAIN_MENU_PAGE("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminCustomers&token=b56060bd9f0cb797ff4dcde04c01cfc4");

    private String URL;

    URLHolder(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
