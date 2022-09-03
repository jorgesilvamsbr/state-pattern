package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.CANCELLED;
import static paymentStatus.PaymentStatusType.CHARGED_BACK;

public class CancelledStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return CANCELLED;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Arrays.asList(CANCELLED);
    }
}
