package DAO.JDBC;

import DAO.IFDetectiveDAO;
import core.Detective;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDetectiveDAO implements IFDetectiveDAO {

    private final static Logger logger = LoggerFactory.getLogger(JDBCDetectiveDAO.class);

    @Override
    public Detective addDetective(Detective detective) {
        String query = "insert into detective_tb(ID, VERSION, CREATED, MODIFIED_AT, BADGENUMBER, ARMED, USER_NAME,\n" +
                "                         FIST_NAME, LAST_NAME, PASSWORD, HIRING_DATE,`RANK`,Status)" +
                "value (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, detective.getId());
            stmt.setInt(2, detective.getVersion());
            stmt.setString(3, detective.getCreated().toString());
            stmt.setString(4, detective.getModifiedAt().toString());
            stmt.setString(5, detective.getBadgeNumber());
            stmt.setBoolean(6, detective.getArmed());
            stmt.setString(7, detective.getUserName());
            stmt.setString(8, detective.getFistName());
            stmt.setString(9, detective.getLastName());
            stmt.setString(10, detective.getPassword());
            stmt.setString(11, detective.getHiringDate().toString());
            stmt.setObject(12, detective.getRank());
            stmt.setObject(13, detective.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public Detective findById(Long id) {
        String query = "SELECT * FROM detective.detective_tb WHERE ID = ?";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Detective detective = DataMapper.get(resultSet);
                if (detective != null) {
                    return detective;
                }
            }
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try {
            String query = "DELETE FROM detective.detective_tb WHERE ID = ?";
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
    }

    @Override
    public Detective updateDetective(Detective detective) {
        String query =
                "UPDATE detective_tb\n" +
                 "SET VERSION = ?, CREATED = ? , MODIFIED_AT = ? ,BADGENUMBER = ? , ARMED = ?, USER_NAME = ? ,\n" +
                 " FIST_NAME = ?, LAST_NAME = ?, PASSWORD = ?, HIRING_DATE = ?,`RANK` = ?,Status = ? WHERE ID = ?;";
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setLong(13, detective.getId());
            stmt.setInt(1, detective.getVersion());
            stmt.setString(2, detective.getCreated().toString());
            stmt.setString(3, detective.getModifiedAt().toString());
            stmt.setString(4, detective.getBadgeNumber());
            stmt.setBoolean(5, detective.getArmed());
            stmt.setString(6, detective.getUserName());
            stmt.setString(7, detective.getFistName());
            stmt.setString(8, detective.getLastName());
            stmt.setString(9, detective.getPassword());
            stmt.setString(10, detective.getHiringDate().toString());
            stmt.setObject(11, detective.getRank());
            stmt.setObject(12, detective.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }

    @Override
    public List<Detective> findAllDetective() {
        List<Detective> detectiveList = new ArrayList<>();
        try {
            Connection con = DataUtility.getDataSource().getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM detective.detective_tb");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Detective detective = DataMapper.get(resultSet);
                if (detective != null) {
                    detectiveList.add(detective);
                }
            }
            return detectiveList;
        } catch (SQLException e) {
            logger.error(e.toString());
        }
        return null;
    }
}
