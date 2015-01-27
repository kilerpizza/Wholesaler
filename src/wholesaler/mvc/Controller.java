package wholesaler.mvc;

import java.math.BigDecimal;

public class Controller {

	private View view;
	private Model model;
	
	public Controller() {
		this.view = new View(this);
		this.model = new Model();
	}
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.startGame();
	}

	private void startGame() {
		model.setBalance(new BigDecimal(1000));
	}

	public void sellProduct(Integer productId, Integer quantity) {
		// upewnij się, że masz tyle tego produktu na stanie
		// zmniejsz liczbę produktów
		// zwiększ saldo
	}

	public void buyProduct(Integer productId, Integer quantity) {
		// upewnij się, że tyle produktów jest dostępnych na rynku
		// upewnij się, że masz wystarczająco dużo kasy
		// dodaj nowy produkt
		// zmniejsz saldo
	}

	public void openWarehouse() {
		// wykonaj operacje kupowania przez klientów
	}

	public void endTurn() {
		// wygeneruj nowe ceny zakupowe i sprzedarzowe i zapisz w modelu, można dla bajeru uzależnić je od popytu/podaży:
		// - jeżeli byli kupujący, ale nie miałeś towaru wystarczającej ilości towaru - cena rośnie
		// - jeżeli towaru sporo zostało - cena maleje
		// - jeżeli towaru wystarczyło i zostało kila sztuk, cena nie zmienia się
		// wygeneruj nowych kupujących i zapisz w modelu
		// zmień dzień na nowy
	}

	// pobieranie danych przez widok
	
	public void selectStockScreen() {
		view.renderStockScreen();
	}
	
	public void selectAvailableItemsScreen() {
		view.renderAvailableItemsScreen();
	}

}
