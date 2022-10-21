import java.util.ArrayList;

public abstract class Calculadora {
    double memoria;
	static String[] ordemOperadores;
	
    public abstract void calcular(String linha );
    public abstract void calcularPilha(ArrayList<Double> num, ArrayList<String> op);

    @Override
    public String toString() {
        return Double.toString(this.memoria);
    }
}
