import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Product> stock = new ArrayList<>();
        stock.add(new Product(Description.ARROZ, 12.0, 20));
        stock.add(new Product(Description.FEIJAO, 7.0, 12));
        stock.add(new Product(Description.FARINHA, 6.49, 32));
        stock.add(new Product(Description.LEITE, 3.2, 50));

        System.out.println("Estoque atual: ");
        for (Product product : stock) {
            System.out.print(product);
        }



        Order order = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu principal:");
            System.out.println("1. Realizer pedido");
            System.out.println("2. Realizar o pagamento");
            System.out.println("0. Sair do programa");
            int op = scanner.nextInt();
            if (op == 0) {
                System.out.println("Fechando o programa!");
                return;
            }
            switch (op) {
                case 1: {
                    System.out.println("Digite o seu nome: ");
                    String name = scanner.next();
                    System.out.println("Digite o seu CPF: ");
                    String cpf = scanner.next();

                    Client client = new Client(name, cpf);
                    order = new Order(client);

                    System.out.println("Seja bem-vindo ao supermercado " + client + ".");


                    while (true) {
                        System.out.println("1. Adicionar item");
                        System.out.println("2. Remove item");
                        System.out.println("3. Ver o seu pedido");
                        System.out.println("0. Voltar para o menu principal");
                        int action = scanner.nextInt();
                        if (action == 0) {
                            break;
                        }
                        switch (action) {
                            case 1: {

                                for (int i = 1; i <= stock.size(); i++) {
                                    int idx = i - 1;
                                    System.out.print(i + ":\n" + stock.get(idx));
                                }

                                System.out.println("Selecione o produto:");
                                int selected = scanner.nextInt();
                                int idx = selected - 1;
                                if (idx < 0 || idx > (stock.size() - 1)) {
                                    System.out.println("Produto " + selected + " inválido.");
                                    break;
                                }
                                Product product = stock.get(idx);
                                System.out.println("Item selecionado: \n" + product);

                                System.out.println("Digite a quantidade:");
                                int amount = scanner.nextInt();
                                if (!product.canBuy(amount)) {
                                    System.out.println("Não há estoque para comprar " + amount + " unidades (estoque atual: " + product.getStockAmount() + ").");
                                    break;
                                }

                                Item item = new Item(product, amount);
                                order.addProduct(item);
                                System.out.println(product + "Adicionado com " + amount + " unidades.");
                                break;
                            }
                            case 2: {
                                System.out.println("Qual item quer remover?");
                                int selected = scanner.nextInt();
                                int idx = selected - 1;
                                if (idx < 0 || idx > (order.getItems().size() - 1)) {
                                    System.out.println("Item " + selected + " não encontrado.");
                                    break;
                                }

                                Item item = order.getItems().remove(idx);
                                System.out.println(item + "Foi removido.");
                                break;
                            }
                            case 3: {
                                System.out.println(order);
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    if (order == null) {
                        System.out.println("Você não criou um pedido.");
                        break;
                    }

                    System.out.println(order);

                    if (order.getItems().isEmpty()) {
                        System.out.println("Não há produtos no pedido.");
                        break;
                    }

                    int i = 1;
                    for (PaymentMethod paymentMethod : PaymentMethod.values()) {
                        System.out.println(i + ". " + paymentMethod.name());
                        i++;
                    }
                    System.out.println("Selecione o método de pagamento: ");
                    int selected = scanner.nextInt();
                    int idx = selected - 1;

                    if (idx < 0 || idx > (PaymentMethod.values().length - 1)) {
                        System.out.println("Item " + selected + " não encontrado.");
                        break;
                    }

                    PaymentMethod paymentMethod = PaymentMethod.values()[idx];
                    order.setPaymentMethod(paymentMethod);

                    System.out.println(order);

                    order.buy();
                    System.out.println("O pedido foi realizado.");

                    System.out.println("Novo estoque: ");
                    for (Product product : stock) {
                        System.out.print(product);
                    }

                    break;
                }
            }
        }

    }


}