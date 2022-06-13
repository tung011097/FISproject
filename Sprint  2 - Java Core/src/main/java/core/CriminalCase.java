package core;

import java.time.LocalDateTime;
import java.util.Set;

public class CriminalCase extends AbstractEmtity {
    private  String number;
    private  String shortDescription;
    private  String detailedDescription;
    private  String notes;
    private Detective leadInvestigator;
    private Set<Detective> assigned;
    private Set<Evidence> evidenceSet;

    public CriminalCase(Long id, int version, LocalDateTime created, LocalDateTime modifiedAt, String number, String shortDescription, String detailedDescription,
                        String notes, Detective leadInvestigator, Set<Detective> assigned, Set<Evidence> evidenceSet) {
        super(id, version, created, modifiedAt);
        this.number = number;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.notes = notes;
        this.leadInvestigator = leadInvestigator;
        this.assigned = assigned;
        this.evidenceSet = evidenceSet;
    }

    public CriminalCase(String number, String shortDescription, String detailedDescription, String notes, Detective leadInvestigator, Set<Detective> assigned, Set<Evidence> evidenceSet) {
        this.number = number;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.notes = notes;
        this.leadInvestigator = leadInvestigator;
        this.assigned = assigned;
        this.evidenceSet = evidenceSet;
    }

    public CriminalCase() {

    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        this.detailedDescription = detailedDescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Detective getLeadInvestigator() {
        return leadInvestigator;
    }

    public void setLeadInvestigator(Detective leadInvestigator) {
        this.leadInvestigator = leadInvestigator;
    }

    public Set<Detective> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<Detective> assigned) {
        this.assigned = assigned;
    }

    public Set<Evidence> getEvidenceSet() {
        return evidenceSet;
    }

    public void setEvidenceSet(Set<Evidence> evidenceSet) {
        this.evidenceSet = evidenceSet;
    }

    @Override
    public String toString() {
        return "CriminalCase{" +
                "number='" + number + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", detailedDescription='" + detailedDescription + '\'' +
                ", notes='" + notes + '\'' +
                ", leadInvestigator=" + leadInvestigator +
                ", assigned=" + assigned +
                ", evidenceSet=" + evidenceSet +
                ", id=" + id +
                ", version=" + version +
                ", created=" + created +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
