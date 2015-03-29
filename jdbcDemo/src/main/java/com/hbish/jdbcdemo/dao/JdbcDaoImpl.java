package com.hbish.jdbcdemo.dao;

import com.hbish.jdbcdemo.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Created by bshi on 28/03/2015.
 */
@Component
public class JdbcDaoImpl {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /* JDBC implementation
    public Circle getCircle(int circleId) {

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from circle where id = ?");
            ps.setInt(1, circleId);

            Circle circle = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                circle = new Circle(circleId, rs.getString("name"));
            }
            rs.close();
            ps.close();
            return circle;
        } catch (Exception ex) {
            throw new RuntimeException();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    */

    public int getCircleCount() {
        String sql = "select COUNT(*) from circle";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public String getCircleName(int circleId) {
        String sql = "select NAME from circle where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, String.class);
    }

    public Circle getCircleForId(int circleId) {
        String sql = "select * from circle where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {circleId}, new CircleRowMapper());
    }

    public List<Circle> getCircles() {
        String sql = "select * from circle";
        return jdbcTemplate.query(sql, new CircleRowMapper());
    }

//    public void insertCircle(Circle circle) {
//        String sql = "insert into circle (ID, NAME) values (?, ?)";
//        jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
//    }

    public void insertCircle(Circle circle) {
        String sql = "insert into circle (ID, NAME) values (:id, :name)";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
                                                    .addValue("name", circle.getName());
        namedParameterJdbcTemplate.update(sql, namedParameters);
    }

    public void createTriangleTable() {
        String sql = "create table triangle (ID integer, name varchar(50)) ";
        jdbcTemplate.execute(sql);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class CircleRowMapper implements RowMapper<Circle> {
        @Override
        public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
            Circle circle = new Circle();
            circle.setId(rs.getInt("ID"));
            circle.setName(rs.getString("NAME"));
            return circle;
        }
    }
}
