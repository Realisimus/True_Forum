package forum;

public class User {

    private String login;
    private String password;
    private String sessionId;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String login() {
        return login;
    }

    public String password() {
        return password;
    }

    public void setSessionId() {
        int min = 10000;
        int max = 99999;
        sessionId = Integer.toString(min + (int)(Math.random() * ((max - min) + 1)));
    }

    public String getSessionId() {
        return sessionId;
    }
}
