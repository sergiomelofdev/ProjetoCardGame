package ResourcesManage;
import Arenas.Field;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;

public class FieldManageResource extends AbstractReadResource{
    public ArrayList<Field> getAllFields() throws IOException {
        String jsonFields = readResouceFile(getResourcePath("GlobalResources", "Fields.json"));
        // gerar o tipo de objeto para ler o json:
        TypeToken<ArrayList<Field>> typeArrayListFields = new TypeToken<ArrayList<Field>>(){};
        return new Gson().fromJson(jsonFields, typeArrayListFields); //retorna todos os campos
    }
}
