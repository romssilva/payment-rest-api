package payment.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import payment.model.Payment;

public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long> {}
