package programacao.mobile.readingwriting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    class Categoria{
        private String nome;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
    class Produto{
        private double preco;
        private String nome;
        private Categoria categoria;
        private boolean situaca;

        public boolean isSituaca() {
            return situaca;
        }

        public void setSituaca(boolean situaca) {
            this.situaca = situaca;
        }

        private Categoria[] subCategorias = new Categoria[2];

        public double getPreco() {
            return preco;
        }

        public void setPreco(double preco) {
            this.preco = preco;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Categoria getCategoria() {
            return categoria;
        }

        public void setCategoria(Categoria categoria) {
            this.categoria = categoria;
        }

        public Categoria[] getSubCategorias() {
            return subCategorias;
        }

        public void setSubCategorias(Categoria[] subCategorias) {
            this.subCategorias = subCategorias;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Produto produto = new Produto();
        //produto.setNome("Leonardo");
        //produto.setPreco(500);
        //produto.setSituaca(true);
        //Categoria categoria = new Categoria();
        //categoria.setNome("produto limpeza");
        //Categoria categoria1 = new Categoria();
        //categoria.setNome("carnes");
        //Categoria[] categorias = {categoria1,categoria};
        //produto.setSubCategorias(categorias);
        //produto.setCategoria(categoria1);

        String json = "";

        Gson gson = new GsonBuilder().create();
        //json=gson.toJson(produto);

        Log.i("File", this.getApplicationContext().getFilesDir().getAbsolutePath());



        File file = new File(this.getApplicationContext().getFilesDir(), "myfile.json");
        try {
            //if (!file.exists()) {
                // caso nao exista ele começa a leitura la embaixo fora do if
                // escreve bite
                FileOutputStream fos = new FileOutputStream(file);
                // escreve string, int, etc
                DataOutputStream dos = new DataOutputStream(fos);
                //"<?xml><data>test escreve dados permanentes </data>"
                dos.write(json.getBytes() );
            //}
            FileInputStream fis= new FileInputStream(file);

            DataInputStream din= new DataInputStream(fis);
            // din. input stream
            byte[] data= new byte[din.available()];
            din.readFully(data);
            String content= new String(data);
            Produto produto = gson.fromJson(content,Produto.class);
            Log.i("File dir: ",file.getAbsolutePath());
            System.out.println("File dir: "+file.getAbsolutePath());
            Log.i("File data: ", content);
            System.out.println("File data: "+content);

        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JSON.parse(str -> objeto)
        // JSON.stringity(objeto -> srt)

        // mongoDB > JSON
        //
        // nodeJs > JSON
        //
        // fornt end > JSON


    }
}