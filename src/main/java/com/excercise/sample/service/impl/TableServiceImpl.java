package com.excercise.sample.service.impl;

import com.excercise.sample.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> searchTableData(String tableName) throws Exception {
       List<Map<String , Object>> tableData = new ArrayList<>();
        try {
            String query = "select * from"+" "+tableName;
            tableData = jdbcTemplate.queryForList(query);
        } catch (Exception exception) {
            return null;
        }
        return tableData;
    }
}
