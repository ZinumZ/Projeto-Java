
import com.example.model.Bolo;

public class testmodel {
    public static void main(String[] args) {
        Bolo b1 = new Bolo("Chocolate", "1", 1100, 2);
        
        double preco = b1.calcularPreco();
        System.out.println("Preço do bolo: " + preco);
    }
}
