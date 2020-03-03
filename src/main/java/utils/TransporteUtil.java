package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TransporteUtil {

	private static Map<String, String> map = new HashMap<String, String>();

	static Random random = new Random();

	public static Map<String, String> getTransporte() {
		map.clear();
		map.put("pesob", "" + random.nextInt(350) * 0.50);
		map.put("pesol", "" + random.nextInt(350) * 0.75);
		map.put("marca", "Amarca" );
		map.put("especie", "EspecieA");

		return map;
	}

}
