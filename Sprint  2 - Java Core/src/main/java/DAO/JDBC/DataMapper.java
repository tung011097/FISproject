package DAO.JDBC;

import core.CriminalCase;
import core.Detective;
import core.Enum.EmploymentStatus;
import core.Enum.Rank;
import core.Evidence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataMapper {
    private final static Logger logger = LoggerFactory.getLogger(DataMapper.class);

    public static Detective get(ResultSet detectiveResultSet) {
        Detective detective = new Detective();
        try {
            detective.setId(detectiveResultSet.getLong(1));
            detective.setVersion(detectiveResultSet.getInt(2));
            detective.setCreated(LocalDateTime.parse(detectiveResultSet.getString("CREATED")));
            detective.setModifiedAt(LocalDateTime.parse(detectiveResultSet.getString("MODIFIED_AT")));
            detective.setBadgeNumber(detectiveResultSet.getString(5));
            detective.setArmed(detectiveResultSet.getBoolean(6));
            detective.setUserName(detectiveResultSet.getString(7));
            detective.setFistName(detectiveResultSet.getString(8));
            detective.setLastName(detectiveResultSet.getString(9));
            detective.setPassword(detectiveResultSet.getString(10));
            detective.setHiringDate(LocalDateTime.parse(detectiveResultSet.getString(11)));
            // detective.setRank(Rank.valueOf(detectiveResultSet.getString(12)));
            //detective.setStatus(EmploymentStatus.valueOf(detectiveResultSet.getString(13)));
            return detective;
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    public static Evidence getEvidence(ResultSet resultSet) {
        Evidence evidence = new Evidence();
        try {
            evidence.setId(resultSet.getLong(1));
            evidence.setVersion(resultSet.getInt(2));
            evidence.setCreated(LocalDateTime.parse(resultSet.getString("CREATED")));
            evidence.setModifiedAt(LocalDateTime.parse(resultSet.getString("MODIFIED_AT")));
            evidence.setNumber(resultSet.getString(5));
            evidence.setIteamName(resultSet.getString(6));
            evidence.setNotes(resultSet.getString(7));
            evidence.setArchived(resultSet.getBoolean(8));
            return evidence;
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    public static CriminalCase getCriminalCase(ResultSet resultSet) throws SQLException {
        CriminalCase criminalCase = new CriminalCase();
        criminalCase.setId(resultSet.getLong(1));
        criminalCase.setVersion(resultSet.getInt(2));
        criminalCase.setCreated(LocalDateTime.parse(resultSet.getString(3)));
        criminalCase.setModifiedAt(LocalDateTime.parse(resultSet.getString(4)));
        criminalCase.setNumber(resultSet.getString(5));
        criminalCase.setShortDescription(resultSet.getString(6));
        criminalCase.setDetailedDescription(resultSet.getString(7));
        criminalCase.setNotes(resultSet.getString(8));
        return criminalCase;
    }
}
