import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import paymentStatus.PaymentStatusType;
import paymentStatus.StatusChangeNotAllowed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PaymentTest {
    @Test
    public void shouldCreatePaymentWithStatusCreated() {
        Payment payment = new Payment();

        assertEquals(PaymentStatusType.CREATED, payment.getStatus());
    }

    @ParameterizedTest
    @EnumSource(value = PaymentStatusType.class, names = { "APPROVED", "IN_PROCESS", "PENDING", "CREATED", "AUTHORIZED", "REJECTED" })
    void mustChangePaymentStateFromCreatedToAllowedStates(PaymentStatusType status) {
        Payment payment = new Payment();

        payment.changeStatus(status);

        assertEquals(status, payment.getStatus());
    }

    @Test
    void mustNotChangePaymentStatusFromCreatedIfNotToAnAllowedStatus() {
        Payment paymentWithStatusCreated = new Payment();

        Executable actionOfChangeStatus = () -> {
            paymentWithStatusCreated.changeStatus(PaymentStatusType.IN_MEDIATION);
        };

        assertThrows(StatusChangeNotAllowed.class, actionOfChangeStatus);
    }

    @ParameterizedTest
    @EnumSource(value = PaymentStatusType.class, names = { "APPROVED", "CHARGED_BACK", "REFUNDED" })
    void mustChangePaymentStateFromApprovedToAllowedStates(PaymentStatusType status) {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.APPROVED);

        payment.changeStatus(status);

        assertEquals(status, payment.getStatus());
    }

    @Test
    void mustNotChangePaymentStatusFromApprovedIfNotToAnAllowedStatus() {
        Payment paymentWithStatusApproved = new Payment();
        paymentWithStatusApproved.changeStatus(PaymentStatusType.APPROVED);

        Executable actionOfChangeStatus = () -> {
            paymentWithStatusApproved.changeStatus(PaymentStatusType.CREATED);
        };

        assertThrows(StatusChangeNotAllowed.class, actionOfChangeStatus);
    }

    @ParameterizedTest
    @EnumSource(value = PaymentStatusType.class, names = { "IN_MEDIATION", "REFUNDED", "APPROVED" })
    void mustChangePaymentStateFromInMediationToAllowedStates(PaymentStatusType status) {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.APPROVED);
        payment.changeStatus(PaymentStatusType.IN_MEDIATION);

        payment.changeStatus(status);

        assertEquals(status, payment.getStatus());
    }

    @Test
    void mustNotChangePaymentStatusFromInMediaitonIfNotToAnAllowedStatus() {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.APPROVED);
        payment.changeStatus(PaymentStatusType.IN_MEDIATION);

        Executable actionOfChangeStatus = () -> {
            payment.changeStatus(PaymentStatusType.CREATED);
        };

        assertThrows(StatusChangeNotAllowed.class, actionOfChangeStatus);
    }

    @ParameterizedTest
    @EnumSource(value = PaymentStatusType.class, names = { "IN_PROCESS", "AUTHORIZED", "APPROVED", "CANCELLED", "REJECTED" })
    void mustChangePaymentStateFromInProcessToAllowedStates(PaymentStatusType status) {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.IN_PROCESS);

        payment.changeStatus(status);

        assertEquals(status, payment.getStatus());
    }

    @Test
    void mustNotChangePaymentStatusFromInProcessIfNotToAnAllowedStatus() {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.IN_PROCESS);

        Executable actionOfChangeStatus = () -> {
            payment.changeStatus(PaymentStatusType.CREATED);
        };

        assertThrows(StatusChangeNotAllowed.class, actionOfChangeStatus);
    }

    @ParameterizedTest
    @EnumSource(value = PaymentStatusType.class, names = { "PENDING", "APPROVED", "CANCELLED", "REJECTED" })
    void mustChangePaymentStateFromPendingToAllowedStates(PaymentStatusType status) {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.PENDING);

        payment.changeStatus(status);

        assertEquals(status, payment.getStatus());
    }

    @Test
    void mustNotChangePaymentStatusFromPendingIfNotToAnAllowedStatus() {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.PENDING);

        Executable actionOfChangeStatus = () -> {
            payment.changeStatus(PaymentStatusType.REFUNDED);
        };

        assertThrows(StatusChangeNotAllowed.class, actionOfChangeStatus);
    }

    @ParameterizedTest
    @EnumSource(value = PaymentStatusType.class, names = { "AUTHORIZED", "APPROVED", "CANCELLED" })
    void mustChangePaymentStateFromAuthorizedToAllowedStates(PaymentStatusType status) {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.AUTHORIZED);

        payment.changeStatus(status);

        assertEquals(status, payment.getStatus());
    }

    @Test
    void mustNotChangePaymentStatusFromAuthorizedIfNotToAnAllowedStatus() {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.AUTHORIZED);

        Executable actionOfChangeStatus = () -> {
            payment.changeStatus(PaymentStatusType.PENDING);
        };

        assertThrows(StatusChangeNotAllowed.class, actionOfChangeStatus);
    }

    @ParameterizedTest
    @EnumSource(value = PaymentStatusType.class, names = { "REFUNDED" })
    void mustChangePaymentStateFromRefoundedToAllowedStates(PaymentStatusType status) {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.APPROVED);
        payment.changeStatus(PaymentStatusType.REFUNDED);

        payment.changeStatus(status);

        assertEquals(status, payment.getStatus());
    }

    @Test
    void mustNotChangePaymentStatusFromRefoundedIfNotToAnAllowedStatus() {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.APPROVED);
        payment.changeStatus(PaymentStatusType.REFUNDED);

        Executable actionOfChangeStatus = () -> {
            payment.changeStatus(PaymentStatusType.PENDING);
        };

        assertThrows(StatusChangeNotAllowed.class, actionOfChangeStatus);
    }

    @ParameterizedTest
    @EnumSource(value = PaymentStatusType.class, names = { "CHARGED_BACK" })
    void mustChangePaymentStateFromChargedBackToAllowedStates(PaymentStatusType status) {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.APPROVED);
        payment.changeStatus(PaymentStatusType.CHARGED_BACK);

        payment.changeStatus(status);

        assertEquals(status, payment.getStatus());
    }

    @Test
    void mustNotChangePaymentStatusFromChargedBackIfNotToAnAllowedStatus() {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.APPROVED);
        payment.changeStatus(PaymentStatusType.CHARGED_BACK);

        Executable actionOfChangeStatus = () -> {
            payment.changeStatus(PaymentStatusType.PENDING);
        };

        assertThrows(StatusChangeNotAllowed.class, actionOfChangeStatus);
    }

    @ParameterizedTest
    @EnumSource(value = PaymentStatusType.class, names = { "CANCELLED" })
    void mustChangePaymentStateFromCancelledToAllowedStates(PaymentStatusType status) {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.PENDING);
        payment.changeStatus(PaymentStatusType.CANCELLED);

        payment.changeStatus(status);

        assertEquals(status, payment.getStatus());
    }

    @Test
    void mustNotChangePaymentStatusFromCancelledIfNotToAnAllowedStatus() {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.PENDING);
        payment.changeStatus(PaymentStatusType.CANCELLED);

        Executable actionOfChangeStatus = () -> {
            payment.changeStatus(PaymentStatusType.APPROVED);
        };

        assertThrows(StatusChangeNotAllowed.class, actionOfChangeStatus);
    }

    @ParameterizedTest
    @EnumSource(value = PaymentStatusType.class, names = { "REJECTED" })
    void mustChangePaymentStateFromRejectedToAllowedStates(PaymentStatusType status) {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.REJECTED);

        payment.changeStatus(status);

        assertEquals(status, payment.getStatus());
    }

    @Test
    void mustNotChangePaymentStatusFromRejectedIfNotToAnAllowedStatus() {
        Payment payment = new Payment();
        payment.changeStatus(PaymentStatusType.REJECTED);

        Executable actionOfChangeStatus = () -> {
            payment.changeStatus(PaymentStatusType.APPROVED);
        };

        assertThrows(StatusChangeNotAllowed.class, actionOfChangeStatus);
    }
}