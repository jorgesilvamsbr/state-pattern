package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.*;

public class InProcessStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return IN_PROCESS;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Arrays.asList(IN_PROCESS, APPROVED, AUTHORIZED, CANCELLED, REJECTED);
    }
}
