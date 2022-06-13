package DAO.JDBC;

import DAO.IFEvidenceDAO;
import core.Evidence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCEvidenceDAO implements IFEvidenceDAO {
    private final static Logger logger = LoggerFactory.getLogger(JDBCEvidenceDAO.class);

    @Override
    public Evidence addEvidence(Evidence evidence) {
        String query = "INSERT INTO evidence_tb(ID, VERSION, CREATED, MODIFIED_AT, NUMBER, ITEAMNAME, NOTES, ARCHIVED, CRIMINAL_CASE)\n" +
                "    VALUE(?,?,?,?,?,?,?,?,?);";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, evidence.getId());
            stmt.setInt(2, evidence.getVersion());
            stmt.setString(3, evidence.getCreated().toString());
            stmt.setString(4, evidence.getModifiedAt().toString());
            stmt.setString(5, evidence.getNumber());
            stmt.setString(6, evidence.getIteamName());
            stmt.setString(7, evidence.getNotes());
            stmt.setBoolean(8, evidence.getArchived());
            stmt.setObject(9, evidence.getCriminalCase());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public Evidence findByIdEvidence(Long id) {
        List<Evidence> evidenceList = new ArrayList<>();
        String query = "SELECT * FROM evidence_tb WHERE ID = ?";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Evidence evidence = DataMapper.getEvidence(resultSet);
                if (evidence != null) {
                    return evidence;
                }
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public void deleteByIdEvidence(Long id) {
        String query = "DELETE FROM evidence_tb WHERE ID = ?";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public Evidence updateEvidence(Evidence evidence) {
        String query = "UPDATE evidence_tb\n" +
                "set  VERSION = ?,CREATED = ?,MODIFIED_AT = ?,`NUMBER` = ?, ITEAMNAME = ?, NOTES = ?, ARCHIVED = ?,CRIMINAL_CASE = ?\n" +
                "WHERE id = ?";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, evidence.getVersion());
            stmt.setString(2, evidence.getCreated().toString());
            stmt.setString(3, evidence.getModifiedAt().toString());
            stmt.setString(4, evidence.getNumber());
            stmt.setString(5, evidence.getIteamName());
            stmt.setString(6, evidence.getNotes());
            stmt.setBoolean(7, evidence.getArchived());
            stmt.setObject(8, evidence.getCriminalCase());
            stmt.setLong(9, evidence.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public List<Evidence> findAllEvidence() {
        List<Evidence> list = new ArrayList<>();
        String query = "SELECT * FROM evidence_tb";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Evidence evidence = DataMapper.getEvidence(resultSet);
                if (evidence != null) {
                    list.add(evidence);
                }
            }
            return list;
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }
}
