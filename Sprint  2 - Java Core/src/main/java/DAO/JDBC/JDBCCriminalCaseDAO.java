package DAO.JDBC;

import DAO.IFCriminalCaseDAO;
import core.CriminalCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JDBCCriminalCaseDAO implements IFCriminalCaseDAO {
    private final static Logger logger = LoggerFactory.getLogger(JDBCCriminalCaseDAO.class);

    @Override
    public CriminalCase addCriminalCase(CriminalCase criminalCase) {
        String query = "insert into criminal_case_tb(id, version, created, modified_at, `number`," +
                " short_description, detailed_description, notes, lead_investigator) \n" +
                "    VALUE (?,?,?,?,?,?,?,?,?);";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, criminalCase.getId());
            stmt.setInt(2, criminalCase.getVersion());
            stmt.setString(3, criminalCase.getCreated().toString());
            stmt.setString(4, criminalCase.getModifiedAt().toString());
            stmt.setString(5, criminalCase.getNumber());
            stmt.setString(6, criminalCase.getShortDescription());
            stmt.setString(7, criminalCase.getDetailedDescription());
            stmt.setString(8, criminalCase.getNotes());
            stmt.setObject(9, criminalCase.getLeadInvestigator());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public CriminalCase findCriminalCaseById(long id) {
        String query = "SELECT * FROM criminal_case_tb\n" +
                "WHERE ID = ?;";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                CriminalCase criminalCase = DataMapper.getCriminalCase(resultSet);
                if (criminalCase != null) {
                    return criminalCase;
                }
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public void deleteCriminalCaseById(long id) {
        String query = "delete FROM criminal_case_tb\n" +
                "where ID = ?;";
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
    public CriminalCase updateCriminalCase(CriminalCase criminalCase) {
        String query = "UPDATE criminal_case_tb\n" +
                "SET VERSION = ?, CREATED = ?, MODIFIED_AT = ?, NUMBER = ?, SHORT_DESCRIPTION = ?," +
                " DETAILED_DESCRIPTION = ?, NOTES = ?, LEAD_INVESTIGATOR = ?\n" +
                "WHERE ID = ?;";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, criminalCase.getVersion());
            stmt.setString(2, criminalCase.getCreated().toString());
            stmt.setString(3, criminalCase.getModifiedAt().toString());
            stmt.setString(4, criminalCase.getNumber());
            stmt.setString(5, criminalCase.getShortDescription());
            stmt.setString(6, criminalCase.getDetailedDescription());
            stmt.setString(7, criminalCase.getNotes());
            stmt.setObject(8, criminalCase.getLeadInvestigator());
            stmt.setLong(9, criminalCase.getId());
            stmt.executeUpdate();
            return criminalCase;
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public List<CriminalCase> findAllCriminalCase() {
        List<CriminalCase> list = new ArrayList<>();
        String query = "SELECT * FROM criminal_case_tb;";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                CriminalCase criminalCase = DataMapper.getCriminalCase(resultSet);
                if (criminalCase != null) {
                    list.add(criminalCase);
                }
            }
            return list;
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }
}
