package ResourcesManage;
import ClientService.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;

public class UserManageResouce extends AbstractReadResource{
    public ArrayList<User> getAllUsers() throws IOException {
        String jsonUsers = readResouceFile(getResourcePath("GlobalResources", "Users.json"));
        // gerar o tipo de objeto para ler o json:
        TypeToken<ArrayList<User>> typeArrayListUsers = new TypeToken<ArrayList<User>>(){};
        return new Gson().fromJson(jsonUsers, typeArrayListUsers); //retorna todas os usuarios
    }
    public User checkUserCredencials(String loginCheck, String passwordCheck) throws IOException {
        ArrayList<User> allUsers = getAllUsers();
        for (User user: allUsers) {
            if(user.checkLogin(loginCheck, passwordCheck)){
                return user;
            }
        }
        return null;
    }

}
