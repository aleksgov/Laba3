import java.util.*;
import java.util.stream.Collectors;

public class third_task {
    public static void main(String[] args) {

        List<Order> orders = Arrays.asList(
                new Order(1, "Alena", 25000, "Pending"),
                new Order(2, "Sergey", 30000, "Shipped"),
                new Order(3, "Alena", 15000, "Delivered"),
                new Order(4, "Sasha", 50000, "Cancelled"),
                new Order(5, "Elisey", 80000, "Pending"),
                new Order(6, "Alice", 60000, "Delivered"),
                new Order(7, "Sasha", 100000, "Delivered"),
                new Order(8, "Daniel", 65000, "Cancelled"),
                new Order(9, "Stepan", 12000, "Pending"),
                new Order(10, "Vladimir", 35000, "Delivered")
        );

        // 1. Отфильтровать заказы со статусом "Pending"
        List<Order> pendingOrders = orders.stream()
                .filter(order -> order.getStatus().equals("Pending"))
                .collect(Collectors.toList());
        System.out.println("\nPending orders: " + pendingOrders);

        // 2. Найти заказ с наибольшей суммой
        Optional<Order> maxOrder = orders.stream()
                .max(Comparator.comparingDouble(Order::getAmount));
        maxOrder.ifPresent(order ->
                System.out.println("\nOrder with max amount: " + order)
        );

        // 3. Подсчитать общее количество заказов каждого статуса
        Map<String, Long> statusCount = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));
        System.out.println("\nOrder count by status: " + statusCount);

        // 4. Сгруппировать заказы по клиентам
        Map<String, List<Order>> ordersByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
        System.out.println("\nOrders grouped by customer: " + ordersByCustomer);

        // 5. Отсортировать заказы по сумме в порядке возрастания
        List<Order> sortedOrders = orders.stream()
                .sorted(Comparator.comparingDouble(Order::getAmount))
                .collect(Collectors.toList());
        System.out.println("\nOrders sorted by amount: " + sortedOrders);

        // 6. Проверить, есть ли заказы с суммой более 50 000
        boolean hasExpensiveOrders = orders.stream()
                .anyMatch(order -> order.getAmount() > 50000);
        System.out.println("\nHas orders over 50,000: " + hasExpensiveOrders);

        // 7. Получить список уникальных клиентов
        List<String> uniqueCustomers = orders.stream()
                .map(Order::getCustomer)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("\nUnique customers: " + uniqueCustomers);
    }
}
