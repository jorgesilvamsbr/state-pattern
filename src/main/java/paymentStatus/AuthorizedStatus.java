package paymentStatus;

import java.util.Arrays;
import java.util.List;

import static paymentStatus.PaymentStatusType.*;

public class AuthorizedStatus implements PaymentStatus {
    @Override
    public PaymentStatusType getStatus() {
        return AUTHORIZED;
    }

    @Override
    public List<PaymentStatusType> getAllowedStates() {
        return Arrays.asList(AUTHORIZED, APPROVED, CANCELLED);
    }
}
