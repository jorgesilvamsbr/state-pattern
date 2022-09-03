package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.*;

public class RefundedStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return REFUNDED;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Arrays.asList(REFUNDED);
    }
}
