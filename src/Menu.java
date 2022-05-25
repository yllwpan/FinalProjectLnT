
public class Menu {
	
	String code;
	String name;
	Integer price;
	Integer stock;
	
	public Menu(String code, String name, Integer price, Integer stock) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Integer getPrice() {
		return price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	

}
