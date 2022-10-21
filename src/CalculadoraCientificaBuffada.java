import java.util.ArrayList;

public class CalculadoraCientificaBuffada extends CalculadoraBuffada {

    static String[] ordemOperadores = {"^", "sqrt", "!"};

    @Override
    public void calcular(String linha) {
        String antesDoIgual = linha + " ";
		String operacao = linha;
		String[] numeros = operacao.split("[\\/\\*\\-\\+!\\^]|sqrt");
		String[] operadores = operacao.split("[0-9.]+[0-9]*");


        ArrayList<Double> num = new ArrayList<Double>();
		ArrayList<String> op = new ArrayList<String>();

		if (numeros[0].isEmpty()) {
			antesDoIgual = this.memoria + antesDoIgual;
			numeros[0] = String.valueOf(memoria);
		}
		
		System.out.print(antesDoIgual);

		for (String numero : numeros) {
			num.add(Double.parseDouble(numero));
		}
		for (String operador : operadores) {
			op.add(operador);
		}

		if (operadores[0].isEmpty()) {
			op.remove(0);
		}

        calcularPilha(num, op);

    }
    
    @Override
    public void calcularPilha(ArrayList<Double> num, ArrayList<String> op) {
        
        Double valor = 0.0;
        
        for(String precedente: ordemOperadores){
			for (int i = 0; i < op.size(); i++) {
				boolean operarPilha = true;

				if (op.get(i).equals(""+precedente)) {
					switch (op.get(i)) {
                        case "^":
						valor = Math.pow(num.get(i), num.get(i + 1));
						break;
                        case "sqrt":
						valor = Math.sqrt(num.get(i+1));
                        operarPilha=false;
						break;
                        case "!":
						Double ac = 1.0;
						for(Double j = 1.0; j <= num.get(i);j++){
							 ac*=j;}
						valor = ac; 
						operarPilha = false;
						break;	
					}

					num.set(i, valor);
					
					if(operarPilha){
						num.remove(i + 1);
						op.remove(i);
						i = -1;
					}
				}
			}
        }
        super.calcularPilha(num, op);
    }
}
