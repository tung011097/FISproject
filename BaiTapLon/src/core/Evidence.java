package core;

import core.AbstractEmtity;
import core.CriminalCase;
import core.TrackEntry;

import java.util.Set;

public class Evidence extends AbstractEmtity {
    private CriminalCase criminalCase;
    private String number;
    private String iteamName;
    private String notes;
    private Boolean archived;
    private Set<TrackEntry> trackEntries;

    public Evidence(CriminalCase criminalCase, String number, String iteamName, String notes, Boolean archived,
                    Set<TrackEntry> trackEntries) {
        super();
        this.criminalCase = criminalCase;
        this.number = number;
        this.iteamName = iteamName;
        this.notes = notes;
        this.archived = archived;
        this.trackEntries = trackEntries;
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
}
