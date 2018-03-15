package application.enums;

public enum URLHolder {
    LOGIN_PAGE ("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/"),
    MAIN_MENU_PAGE("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminCustomers&token=b56060bd9f0cb797ff4dcde04c01cfc4"),
    KATALOG("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php/product/catalog?_token=A2V8bJocELb6qN1vUNJfVWTG6TUHovkdBeOga-qbnR8"),
    KATEGORY("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminCategories&token=795a6350b3a0f87af2a165b4c1a34372"),
    NEWKATEGORY("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/index.php?controller=AdminCategories&addcategory&token=795a6350b3a0f87af2a165b4c1a34372"),
    USER_START_PAGE("http://prestashop-automation.qatestlab.com.ua/ru/");

    private String URL;

    URLHolder(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }
}
