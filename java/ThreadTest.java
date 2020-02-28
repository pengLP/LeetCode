import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String userName;

    public User(String id, String user) {
        this.userId = id;
        this.userName = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}

public abstract class ThreadTest {
    public int test() {
        return 1;
    }

    public static void main(String[] args) {

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.txt"));
            User user = (User) objectInputStream.readObject();
            System.out.println(user);
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}