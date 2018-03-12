package application.pages.enums;

public enum UserData {
    LOGIN("webinar.test@gmail.com"), PASS("Xcg7299bnSmMuRLp9ITw");
    private String data;

    UserData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
