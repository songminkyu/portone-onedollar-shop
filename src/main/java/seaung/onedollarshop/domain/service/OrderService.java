package seaung.onedollarshop.domain.service;

import seaung.onedollarshop.domain.entity.Member;
import seaung.onedollarshop.domain.entity.Order;

public interface OrderService {
    Order autoOrder(Member member); // 자동 주문
}
