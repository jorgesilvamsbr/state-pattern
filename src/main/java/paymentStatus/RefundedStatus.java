package paymentStatus;

import java.util.Collections;
import java.util.List;

import static paymentStatus.PaymentStatusType.REFUNDED;

public class RefundedStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return REFUNDED;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Collections.singletonList(REFUNDED);
    }
}
