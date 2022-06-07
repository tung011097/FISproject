package core;

import java.util.Set;

public class Detective extends AbstractEmtity {
    private Person person;
    private  String badgeNumber;
    private  Boolean armed;
    private Set<CriminalCase> criminalCases;
    private EmploymentStatus status;
    private Rank rank;

    public Detective(Person person, String badgeNumber, Boolean armed, Set<CriminalCase> criminalCases, EmploymentStatus status, Rank rank) {
        this.person = person;
        this.badgeNumber = badgeNumber;
        this.armed = armed;
        this.criminalCases = criminalCases;
        this.status = status;
        this.rank = rank;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public Boolean getArmed() {
        return armed;
    }

    public void setArmed(Boolean armed) {
        this.armed = armed;
    }

    public Set<CriminalCase> getCriminalCases() {
        return criminalCases;
    }

    public void setCriminalCases(Set<CriminalCase> criminalCases) {
        this.criminalCases = criminalCases;
    }

    public EmploymentStatus getStatus() {
        return status;
    }

    public void setStatus(EmploymentStatus status) {
        this.status = status;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}
