package save;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Conta;


public class ArquivarUtil {

    private String filePath = "/src/save";
    private File cadastros = new File("src/save/cadastros.json");

    private Gson gson = new Gson();

    public void salvarUsuarios(ArrayList contas) {
        try{
            new File(filePath).mkdir();
            String contasJson = gson.toJson(contas);
            FileWriter writer = new FileWriter(cadastros);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(contasJson);

            bw.close();
            writer.close();
        }catch (IOException e){
            System.out.println("Erro ao salvar o arquivo");
        }
    }

    public ArrayList<Conta> lerUsuarios() {
        try {
            Type tipoDeLista = new TypeToken<ArrayList<Conta>>() {}.getType();
            Reader leitor = new FileReader(cadastros);
            ArrayList<Conta> contas = gson.fromJson(leitor,tipoDeLista);
            return contas;
        }catch(FileNotFoundException e){
            new File(filePath).mkdir();
            ArrayList<Conta> contas = new ArrayList<>();
            return contas;
        }

    }


}
