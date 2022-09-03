package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.*;

public class InMediationStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return IN_MEDIATION;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Arrays.asList(APPROVED, IN_MEDIATION, REFUNDED);
    }
}
