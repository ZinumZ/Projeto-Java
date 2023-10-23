
import com.example.model.Bolo;
import com.example.model.Salgado;
import com.example.model.Suco;

public class testmodel {
    public static void main(String[] args) {
        Bolo b1 = new Bolo("Bolo","Chocolate", "1", 1100, 2);
        
        double precoBolo = b1.calcularPreco();
        System.out.println("Preço do bolo: " + precoBolo);

        Suco s1 = new Suco("Suco","Laranja", "2", 250); //Tamanhos: 250,500,700
        double precoSuco = s1.calcularPreco();
        System.out.println("Preço do suco: " + precoSuco);

        Salgado sal1 = new Salgado("Empadinha","Carne", "3", false);
        double precoSalgado = sal1.calcularPreco();
        System.out.println("Preço do salgado: " + precoSalgado);
    }
}
