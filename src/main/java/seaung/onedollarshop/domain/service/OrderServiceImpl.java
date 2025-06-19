package seaung.onedollarshop.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seaung.onedollarshop.domain.entity.Member;
import seaung.onedollarshop.domain.entity.Order;
import seaung.onedollarshop.domain.entity.Payment;
import seaung.onedollarshop.domain.entity.PaymentStatus;
import seaung.onedollarshop.domain.repository.OrderRepository;
import seaung.onedollarshop.domain.repository.PaymentRepository;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public Order autoOrder(Member member) {

        // 임시 결제내역 생성
        Payment payment = Payment.builder()
                .price(1000L)
                .status(PaymentStatus.READY)
                .build();

        paymentRepository.save(payment);

        // 주문 생성
        Order order = Order.builder()
                .member(member)
                .price(1000L)
                .itemName("1달러샵 상품")
                .orderUid(UUID.randomUUID().toString())
                .payment(payment)
                .build();

        return orderRepository.save(order);
    }
}
