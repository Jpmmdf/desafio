package br.com.milhome.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Joao Pedro Machado Milhome
 *
 */

public class UtilText {
	private final String delimitador1 = "(";
	private final String delimitador2 = ")";
	private String texto;

	public UtilText() {
	}

	public UtilText(String texto) {
		setTexto(texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	private String getDelimitador1() {
		return delimitador1;
	}

	private String getDelimitador2() {
		return delimitador2;
	}

	private int isBalance(String expressao) {
		Matcher ma = Pattern.compile(expressao).matcher(getTexto());
		int cont = 0;
		while (ma.find()) {
			cont++;
		}
		return cont;

	}

	public boolean isBalanceWithoutRecursion() {
		if (getTexto() != null) {
			return (isBalance("\\(") == isBalance("\\)"));
		}
		return false;
	}

	/**
	 * Encapsulando os valores iniciais do contador e a posicao inicial
	 * 
	 * @author Joao Pedro Machado Milhome
	 * @param Texto
	 *            que será buscado a expressao
	 * 
	 */
	private boolean isBalance(int posicao, int contador) {
		if (getTexto().isEmpty()) {
			return true;
		} else {
			if (posicao < getTexto().length()) {
				if (getTexto().charAt(posicao) == getDelimitador1().charAt(0)) {
					contador++;
					return isBalance(posicao + 1, contador);
				} else if (getTexto().charAt(posicao) == getDelimitador2()
						.charAt(0)) {
					contador--;
					return isBalance(posicao + 1, contador);
				} else {
					return isBalance(posicao + 1, contador);
				}
			}
			return (contador == 0 ? true : false);

		}

	}

	/**
	 * @author Joao Pedro Machado Milhome
	 * @param texto
	 */
	public boolean isBalanceWithRecursion() {
		if (getTexto() != null) {
			return (isBalance(0, 0));

		}
		return false;
	}

}
