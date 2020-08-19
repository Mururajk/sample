package com.excercise.sample.controller;

import com.excercise.sample.result.ApiResult;
import com.excercise.sample.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tables")
public class TableController {


    @Autowired
    private TableService tableService;

    @RequestMapping("/getTableData/{tableName}")
    public ApiResult getTableData(@PathVariable("tableName") String tableName) throws Exception {

        if(tableName.isEmpty())
            return new ApiResult(false ,"Please enter a table name");

        List<Map<String , Object>>  table_data = tableService.searchTableData(tableName);

        if(table_data == null)
            return new ApiResult(false , "Table not found");

        return new ApiResult(true ,table_data,tableName + " Table Data's are Listed");
    }
}
