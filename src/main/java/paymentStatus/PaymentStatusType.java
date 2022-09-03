package paymentStatus;

public enum PaymentStatusType {
    CREATED("Created", new CreatedStatus()),
    APPROVED("Approved", new ApprovedStatus()),
    IN_PROCESS("In Process", new InProcessStatus()),
    PENDING("Pending", new PendingStatus()),
    AUTHORIZED("Authorized", new AuthorizedStatus()),
    REJECTED("Reject", new RejectedStatus()),
    IN_MEDIATION("In Mediation", new InMediationStatus()),
    REFUNDED("Refunded", new RefundedStatus()),
    CHARGED_BACK("Charged Back", new ChargedBackStatus()),
    CANCELLED("Cancelled", new CancelledStatus());

    private String description;
    private Object stateClass;

    PaymentStatusType(String description, Object stateClass) {
        this.description = description;
        this.stateClass = stateClass;
    }

    public String getDescription() {
        return this.description;
    }

    public PaymentStatus getStateClass() {
        return (PaymentStatus) this.stateClass;
    }
}
