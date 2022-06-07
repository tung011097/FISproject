package core;

import java.time.LocalDateTime;

public class TrackEntry extends AbstractEmtity {
    public LocalDateTime date;
    private Evidence evidence;
    private TrackAction action;
    private String reason;

    public TrackEntry(LocalDateTime date, Evidence evidence, TrackAction action, String reason) {
        super();
        this.date = date;
        this.evidence = evidence;
        this.action = action;
        this.reason = reason;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Evidence getEvidence() {
        return evidence;
    }

    public void setEvidence(Evidence evidence) {
        this.evidence = evidence;
    }

    public TrackAction getAction() {
        return action;
    }

    public void setAction(TrackAction action) {
        this.action = action;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
