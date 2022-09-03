package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.CHARGED_BACK;
import static paymentStatus.PaymentStatusType.REFUNDED;

public class ChargedBackStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return CHARGED_BACK;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Arrays.asList(CHARGED_BACK);
    }
}
