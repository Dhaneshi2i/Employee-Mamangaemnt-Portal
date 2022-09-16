package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import jbr.springmvc.model.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import javax.sql.DataSource;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(Contact contact){
        String sql = "insert into users1 (name, email, address) values (?,?,?)";
        jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress());
    }

    public List<Contact> list() {
        String sql = "select * from users1";
        List<Contact> listContact = jdbcTemplate.query(sql, new RowMapper<Contact>() {


            public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
                Contact contact = new Contact();

                contact.setName(rs.getString("name"));
                contact.setEmail(rs.getString("email"));
                contact.setAddress(rs.getString("address"));

                return (Contact) contact;
            }
        } );
        return listContact;
    }
}


