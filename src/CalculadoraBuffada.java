// package testeJava;

import java.util.ArrayList;

class CalculadoraBuffada extends Calculadora {

	double memoria = 0.0;
	static String[] ordemOperadores = {"*","/","+","-"};
	public CalculadoraBuffada() {}


	public CalculadoraBuffada(String linha) {
		calcular(linha);
	}



	@Override
	public void calcular(String linha) {

		String antesDoIgual = linha + " ";
		String operacao = linha;
		String[] numeros = operacao.split("[\\/\\*\\-\\+]");
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


				if (op.get(i).equals(precedente)) {
					switch (op.get(i)) {
					case "*":
						valor = num.get(i) * num.get(i + 1);
						break;
					case "/":
						valor = num.get(i) / num.get(i + 1);
						break;
					case "+":
						valor = num.get(i) + num.get(i + 1);
						break;
					case "-":
						valor = num.get(i) - num.get(i + 1);
						break;
					}

					num.set(i, valor);
					num.remove(i + 1);
					op.remove(i);
					i = -1;
					
				}
			}
		}

		this.memoria = num.get(0);
		System.out.println("= " + this.memoria + System.lineSeparator());
		
	}


	
}
