package lab1;

public class RouteTest {
	public static void main(String args[]) {
		Route route = new Route();
		
		String[] addresses = {"123 Sesame St","221B Baker St","124 Conch St","322 Maple St",
				"485 Maple Dr","698 Candlewood Ln","1640 Riverside Dr","84 Beacon St",
				"320 Fowler St","711 Maple St","4 Privet Dr","129 W 81 St","1407 Graymalkin Ln"};
		int numStops = addresses.length;
		
		int[] orderNumbers = new int[numStops];
		for(int i = 0; i < numStops; i++) {
			orderNumbers[i] = 100+i;
		}
		
		System.out.println("addEnd:");
		for(int i = 0; i < numStops; i++) {
			route.addEnd(addresses[i], orderNumbers[i]);
		}
		System.out.println(route.toString());
		
		route = new Route();
		System.out.println("addStart:");
		for(int i = 0; i < numStops; i++) {
			route.addStart(addresses[i], orderNumbers[i]);
		}
		System.out.println(route.toString());
		
		route = new Route();
		System.out.println("insert:");
		for(int i = 0; i < numStops; i++) {
			route.insert(addresses[i], orderNumbers[i]);
		}
		System.out.println(route.toString());
	}
}
