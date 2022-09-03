package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.*;

public class CreatedStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return PaymentStatusType.CREATED;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Arrays.asList(CREATED, APPROVED, REJECTED, AUTHORIZED, IN_PROCESS, PENDING);
    }
}
