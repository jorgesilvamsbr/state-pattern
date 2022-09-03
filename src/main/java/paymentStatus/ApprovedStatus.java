package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.*;

public class ApprovedStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return APPROVED;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Arrays.asList(APPROVED, CHARGED_BACK, REFUNDED, IN_MEDIATION);
    }
}
