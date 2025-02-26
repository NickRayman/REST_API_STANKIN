package com.application.rest_api_stankin.controller;

import com.application.rest_api_stankin.DTO.OrderDTO;
import com.application.rest_api_stankin.entity.Client;
import com.application.rest_api_stankin.entity.Order;
import com.application.rest_api_stankin.entity.Part;
import com.application.rest_api_stankin.entity.enum_entity.OrderStatus;
import com.application.rest_api_stankin.repository.ClientRepository;
import com.application.rest_api_stankin.repository.OrderRepository;
import com.application.rest_api_stankin.repository.PartRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Контроллер для управления заказами (с использованием DTO)
 */
@Tag(name = "Orders API", description = "Методы для управления заказами")
@Slf4j
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final PartRepository partRepository;

    @Operation(summary = "Создать новый заказ", description = "Добавляет новый заказ в базу данных")
    @PostMapping("/add")
    public Order createOrder(@RequestBody OrderDTO orderDTO) {
        Client client = clientRepository.findById(orderDTO.getClientId()).orElseThrow();
        Part part = partRepository.findById(orderDTO.getPartId()).orElseThrow();

        Order order = new Order();
        order.setClient(client);
        order.setPart(part);
        order.setStatus(OrderStatus.valueOf(orderDTO.getStatus()));

        log.info("Создан заказ: {}", order);
        return orderRepository.save(order);
    }

    @Operation(summary = "Получить список всех заказов", description = "Возвращает список всех заказов")
    @GetMapping("/all")
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(order -> {
            OrderDTO dto = new OrderDTO();
            dto.setOrderId(order.getId());
            dto.setClientId(order.getClient().getId());
            dto.setPartId(order.getPart().getId());
            dto.setStatus(order.getStatus().name());
            return dto;
        }).collect(Collectors.toList());
    }

    @Operation(summary = "Получить заказ по ID", description = "Возвращает заказ по введенному id")
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @Operation(summary = "Обновить заказ по ID", description = "Обновляет заказ по введенному id")
    @PutMapping("/set")
    public Order updateOrder(@RequestBody OrderDTO orderDetails) {
        Order order = orderRepository.findById(orderDetails.getOrderId()).orElseThrow();
        order.setStatus(OrderStatus.valueOf(orderDetails.getStatus()));
        return orderRepository.save(order);
    }

    @Operation(summary = "Удалить заказ по ID", description = "Удаляет заказ по введенному id")
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
}
