package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.*;

public class PendingStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return PENDING;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Arrays.asList(PENDING, APPROVED, CANCELLED, REJECTED);
    }
}
