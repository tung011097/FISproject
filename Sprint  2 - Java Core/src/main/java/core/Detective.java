package core;

import core.Enum.EmploymentStatus;
import core.Enum.Rank;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class Detective extends AbstractEmtity {
    private  String userName;
    private  String fistName;
    private  String lastName;
    private  String password;
    private LocalDateTime hiringDate;
    private  String badgeNumber;
    private  Boolean armed;
    private Set<CriminalCase> criminalCases;
    private EmploymentStatus status;
    private Rank rank;

    public Detective(Long id, int version, LocalDateTime created, LocalDateTime modifiedAt, String userName,
                     String fistName, String lastName, String password, LocalDateTime hiringDate, String badgeNumber, Boolean armed, Set<CriminalCase> criminalCases, EmploymentStatus status, Rank rank) {
        super(id, version, created, modifiedAt);
        this.userName = userName;
        this.fistName = fistName;
        this.lastName = lastName;
        this.password = password;
        this.hiringDate = hiringDate;
        this.badgeNumber = badgeNumber;
        this.armed = armed;
        this.criminalCases = criminalCases;
        this.status = status;
        this.rank = rank;
    }

    public Detective() {
        super();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDateTime hiringDate) {
        this.hiringDate = hiringDate;
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

    @Override
    public String toString() {
        return "Detective{" +
                "userName='" + userName + '\'' +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", hiringDate=" + hiringDate +
                ", badgeNumber='" + badgeNumber + '\'' +
                ", armed=" + armed +
                ", criminalCases=" + criminalCases +
                ", status=" + status +
                ", rank=" + rank +
                ", id=" + id +
                ", version=" + version +
                ", created=" + created +
                ", modifiedAt=" + modifiedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Detective detective = (Detective) o;
        return Objects.equals(userName, detective.userName) && Objects.equals(fistName, detective.fistName) && Objects.equals(lastName, detective.lastName) && Objects.equals(password, detective.password) && Objects.equals(hiringDate, detective.hiringDate) && Objects.equals(badgeNumber, detective.badgeNumber) && Objects.equals(armed, detective.armed) && Objects.equals(criminalCases, detective.criminalCases) && status == detective.status && rank == detective.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, fistName, lastName, password, hiringDate, badgeNumber, armed, criminalCases, status, rank);
    }
}
