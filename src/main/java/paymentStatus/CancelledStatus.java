package paymentStatus;

import java.util.Collections;
import java.util.List;

import static paymentStatus.PaymentStatusType.CANCELLED;

public class CancelledStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return CANCELLED;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Collections.singletonList(CANCELLED);
    }
}
