package core;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class Evidence extends AbstractEmtity {
    private CriminalCase criminalCase;
    private String number;
    private String iteamName;
    private String notes;
    private Boolean archived;
    private Set<TrackEntry> trackEntries;

    public Evidence(Long id, int version, LocalDateTime created, LocalDateTime modifiedAt, CriminalCase criminalCase,
                    String number, String iteamName, String notes, Boolean archived, Set<TrackEntry> trackEntries) {
        super(id, version, created, modifiedAt);
        this.criminalCase = criminalCase;
        this.number = number;
        this.iteamName = iteamName;
        this.notes = notes;
        this.archived = archived;
        this.trackEntries = trackEntries;
    }

    public Evidence(CriminalCase criminalCase, String number, String iteamName, String notes, Boolean archived, Set<TrackEntry> trackEntries) {
        this.criminalCase = criminalCase;
        this.number = number;
        this.iteamName = iteamName;
        this.notes = notes;
        this.archived = archived;
        this.trackEntries = trackEntries;
    }

    public Evidence() {

    }


    public CriminalCase getCriminalCase() {
        return criminalCase;
    }

    public void setCriminalCase(CriminalCase criminalCase) {
        this.criminalCase = criminalCase;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIteamName() {
        return iteamName;
    }

    public void setIteamName(String iteamName) {
        this.iteamName = iteamName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Set<TrackEntry> getTrackEntries() {
        return trackEntries;
    }

    public void setTrackEntries(Set<TrackEntry> trackEntries) {
        this.trackEntries = trackEntries;
    }

    @Override
    public String toString() {
        return "Evidence{" +
                "criminalCase=" + criminalCase +
                ", number='" + number + '\'' +
                ", iteamName='" + iteamName + '\'' +
                ", notes='" + notes + '\'' +
                ", archived=" + archived +
                ", trackEntries=" + trackEntries +
                ", id=" + id +
                ", version=" + version +
                ", createdA=" + created +
                ", modifiedAt=" + modifiedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Evidence evidence = (Evidence) o;
        return Objects.equals(criminalCase, evidence.criminalCase) && Objects.equals(number, evidence.number) && Objects.equals(iteamName, evidence.iteamName) && Objects.equals(notes, evidence.notes) && Objects.equals(archived, evidence.archived) && Objects.equals(trackEntries, evidence.trackEntries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criminalCase, number, iteamName, notes, archived, trackEntries);
    }
}
