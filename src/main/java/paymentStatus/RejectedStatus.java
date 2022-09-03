package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.CANCELLED;
import static paymentStatus.PaymentStatusType.REJECTED;

public class RejectedStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return REJECTED;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Arrays.asList(REJECTED);
    }
}
