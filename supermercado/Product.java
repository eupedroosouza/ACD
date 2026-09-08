

public class Product {

    private Description description;
    private double price;
    private int stockAmount;

    public Product(Description description, double price, int stockAmount) {
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public boolean canBuy(int amount) {
        return stockAmount > amount;
    }

    public void buy(int amount) {
        if (!canBuy(amount)) {
            return;
        }
        this.stockAmount -= amount;
    }

    public double getPrice() {
        return price;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Produto:\n");
        sb.append("  Descrição: ").append(description.name()).append("\n");
        sb.append("  Preço: ").append(String.format("%.2f", price)).append("\n");
        sb.append("  Estoque: ").append(stockAmount).append("\n");
        return sb.toString();
    }
}