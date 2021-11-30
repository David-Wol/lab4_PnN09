package login;

public class User {

    private final String login;
    private final String password;

    User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public String getLogin(){return login;}


    public String getPassword(){return password;}

}