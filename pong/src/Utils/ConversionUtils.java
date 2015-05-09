package Utils;

public class ConversionUtils {

	/**
	 * Convertit une valeur relative (0-100) en une valeur absolue par rapport à un maximum. Exemple
	 * : ConversionUtils.toAbsolute(25, 800) = 200
	 * 
	 * @param val valeur à convertir
	 * @param max maximum (correspondant à 100)
	 * @return valeur convertie en absolu
	 */
	public static int toAbsolute(double val, int max) {
		return toAbsolute(val, (double) max);
	}

	/**
	 * Convertit une valeur relative (0-100) en une valeur absolue par rapport à un maximum. Exemple
	 * : ConversionUtils.toAbsolute(25, 800) = 200
	 * 
	 * @param val valeur à convertir
	 * @param max maximum (correspondant à 100)
	 * @return valeur convertie en absolu
	 */
	public static int toAbsolute(double val, double max) {
		return (int) Math.round(val / 100.0 * max);
	}
}
