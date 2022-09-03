import paymentStatus.CreatedStatus;
import paymentStatus.PaymentStatus;
import paymentStatus.PaymentStatusType;

public class Payment {
    private PaymentStatus status;

    public Payment() {
        this.status = new CreatedStatus();
    }

    public PaymentStatusType getStatus() {
        return status.getStatus();
    }

    public void changeStatus(PaymentStatusType nextPaymentStatusType) {
        this.status = this.status.changeStatus(nextPaymentStatusType);
    }
}