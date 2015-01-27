package wholesaler.mvc;

/*
 * Na każdym ekranie wyświetlamy stan konta (kaski) i menu podpowiadające akcje, które możemy wykonać - zrób to oddzielną funkcją.
 * Po wykonaniu akcji innych niż zmiana ekranu, zawsze pozostajemy na tym samym ekranie.
 * 
 * To ta klasa powinna wypisywać komunikaty na ekranie.
 * To ta klasa powinna czekać na input użytkownika.
 * Ta klasa powinna mieć dostęp do controllera i na nim wołać już odpowiednie akcje.
 */
public class View {
	
	private Controller controller;

	public View(Controller controller) {
		this.controller = controller;
	}

	/*
	 * Wyświetla:
	 * - stan magazynu
	 * - przy każdej pozycji wyświetla jej numerek
	 * - wpisanie numerku i enter umożliwia sprzedanie tej pozycji - pyta dodatkowo o ilość
	 * - po sprzedarzy ekran jest renderowany na nowo
	 * - jeżeli wpiszemy "b" (buy) zamiast numerka, przechodzimy na ekran AvailableItemsScreen
	 * - jeżeli wpiszemy "o" (open) zamiast numerka, otwieramy hurtownię
	 * - jeżeli wpiszemy "e" (end) zamiast numerka, kończymy turę 
	 */
	public void renderStockScreen() {
		
		// np. jeżeli użytkownik wybierze "b"
		controller.selectAvailableItemsScreen();
	}

	/*
	 * Wyświetla:
	 * - listę dostępnych pozycji i ich ceny
	 * - przy każdej pozycji wyświetla jej numerek
	 * - wpisanie numerku i enter umożliwia zakup tej pozycji - pyta dodatkowo o ilość
	 * - po sprzedarzy ekran jest renderowany na nowo, lista dostępnych pozycji zmniejsza się
	 * - jeżeli wpiszemy "s" (sell) zamiast numerka, przechodzimy na ekran StockScreen
	 * - jeżeli wpiszemy "o" (open) zamiast numerka, otwieramy hurtownię
	 * - jeżeli wpiszemy "e" (end) zamiast numerka, kończymy turę
	 */
	public void renderAvailableItemsScreen() {
		// np. jeżeli użytkownik chce kupić 3 produkty o identyfikatorze 10
		controller.buyProduct(10, 3);
	}
}
