public class Item {

    private Product product;
    private int amount;

    public Item(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item:\n");
        sb.append(product.toString());
        sb.append(" Quantidade: ").append(amount).append("\n");
        return sb.toString();
    }
}
