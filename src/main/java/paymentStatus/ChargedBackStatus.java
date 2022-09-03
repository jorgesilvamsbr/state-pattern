package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.CHARGED_BACK;

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
