package br.com.milhome.mains;

import java.util.ArrayList;
import java.util.List;

import br.com.milhome.util.UtilText;

public class Main {
	public static void main(String[] args) {

		List<String> texto = new ArrayList<String>();
		texto.add("((1+1)*2) + (10+2) + (((2-1)-1)*1)");
		texto.add("O Fulano (aquele que fez aniversário hoje) perguntou por você.");
		texto.add("&:)");

		UtilText text = new UtilText();
		for (String string : texto) {
			text.setTexto(string);
			System.out.println("Com recursividade resultado = "
					+ text.isBalanceWithRecursion());
			System.out.println("Sem recursividade resultado = "
					+ text.isBalanceWithoutRecursion());

		}

	}
}
