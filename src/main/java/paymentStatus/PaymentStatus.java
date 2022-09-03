package paymentStatus;

import java.util.List;

public interface PaymentStatus {

    PaymentStatusType getStatus();

    List<PaymentStatusType> getAllowedStates();

    default PaymentStatus changeStatus(PaymentStatusType nextPaymentStatus) {
        if (this.getAllowedStates().contains(nextPaymentStatus)) {
            return nextPaymentStatus.getStateClass();
        } else {
            throw new StatusChangeNotAllowed(this, nextPaymentStatus);
        }
    }
}
