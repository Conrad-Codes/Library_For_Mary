package com.techelevator.dao;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserReadingListDAOJdbcTests extends FinalCapstoneDaoTests {
    private UserReadingListDAO sut;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate( dataSource );
//        sut = new User
    }
}
