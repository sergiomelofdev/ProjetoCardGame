package TratamentoJson;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractReadResource {
    public Path getResourcePath(String nameFile) { //add depois um exception criado
        Path caminhoRelativo = Paths.get("resources", nameFile);
        return Paths.get(System.getProperty("user.dir")).resolve(caminhoRelativo);
    }
    public String readResouceFile(Path resouceFilePath) throws IOException {
        return String.join(" ",
                Files.readAllLines(
                        resouceFilePath,
                        StandardCharsets.UTF_8)
        );
    }
}
