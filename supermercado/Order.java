import java.util.ArrayList;
import java.util.List;

public class Order {

    private Client client;
    private List<Item> items;
    private PaymentMethod paymentMethod;

    public Order(Client client) {
        this.client = client;
        this.items = new ArrayList<>();
        this.paymentMethod = null;
    }

    public void addProduct(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getTotalPrice() {
        double value = 0d;
        for (Item item : items) {
            value += item.getProduct().getPrice() * item.getAmount();
        }
        return value;
    }

    public void buy() {
        for (Item item : items) {
            item.getProduct().buy(item.getAmount());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seus pedido:\n");
        if (items.isEmpty()) {
            sb.append("- Não há itens no pedido");
        } else {
            for (int i = 1; i <= items.size(); i++) {
                int idx = i - 1;
                sb.append(i).append(":\n").append(items.get(idx));
            }
        }
        sb.append("Total do pedido: R$").append(String.format("%.2f", getTotalPrice())).append("\n");
        sb.append("Método de pagamento: ").append(paymentMethod == null ? "Não definido" : paymentMethod.name());
        return sb.toString();
    }


}
