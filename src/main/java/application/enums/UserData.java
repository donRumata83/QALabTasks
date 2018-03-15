package application.adminPages.enums;

public enum UserData {
    LOGIN("webinar.test@gmail.com"), PASS("Xcg7299bnSmMuRLp9ITw"), NEW_CATEGORY("New category"), CPU("cpu"), NEWGOOD("New Good");
    private String data;

    UserData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
