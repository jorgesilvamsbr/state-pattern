package paymentStatus;

import java.util.Collections;
import java.util.List;

import static paymentStatus.PaymentStatusType.REJECTED;

public class RejectedStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return REJECTED;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Collections.singletonList(REJECTED);
    }
}
