package com.example.Bonyah.Service;

import com.example.Bonyah.Api.ApiException;
import com.example.Bonyah.Models.Orders;
import com.example.Bonyah.Repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo orderRepo;


    public List<Orders> getAllOrder() {
        return orderRepo.findAll();
    }

    public void addOrder(Orders order) {
        orderRepo.save(order);
    }

    public void updateOrder(Integer id, Orders order) {
        Orders order1 = orderRepo.findOrdersById(id);
        if (order1 == null) {
            throw new ApiException("id not founded");
        }
        order1.setStatus("waiting");
        order1.setQuantity(order.getQuantity());
        order1.setTotal(order.getTotal());
        order1.setLocation(order.getLocation());

        orderRepo.save(order1);
    }

    public void deleteOrder(Integer id) {
        Orders order = orderRepo.findOrdersById(id);
        if (order == null) {
            throw new ApiException("id not founded");
        }
        orderRepo.delete(order);
    }
}
