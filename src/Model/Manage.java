package Model;

/**
 * @Author licc on 2020/12/25 15:04
 */
public class Manage {

    private long id;

    private String username;

    private String password;

    private boolean status;

    public boolean isStatus() {
        return status;
    }
//
    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
