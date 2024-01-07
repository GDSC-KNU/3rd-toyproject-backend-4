package com.example.kiosk.dto;

import com.example.kiosk.domain.cart.Cart;
import com.example.kiosk.domain.payment.Payment;
import com.example.kiosk.types.PaymentMethod;
import com.example.kiosk.validation.ValidEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PaymentRequest {
    private Long cartId;
    @ValidEnum(enumClass = PaymentMethod.class, message = "올바르지 않은 결제수단입니다.")
    private String paymentMethod;


    public Payment toEntity(Cart cart) {
        return Payment.builder()
                .cart(cart)
                .paymentMethod(PaymentMethod.valueOf(paymentMethod))
                .build();
    }
}
