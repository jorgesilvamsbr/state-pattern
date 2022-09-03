package paymentStatus;

public class StatusChangeNotAllowed extends RuntimeException {
    public StatusChangeNotAllowed(PaymentStatus paymentStatus, PaymentStatusType nextPaymentStatus) {
        super("It is not allowed to change the status from " + paymentStatus.getStatus().getDescription() + " to " + nextPaymentStatus.getDescription());

    }
}
