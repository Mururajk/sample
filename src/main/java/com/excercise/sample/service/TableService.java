package com.excercise.sample.service;

import java.util.List;
import java.util.Map;

public interface TableService {

    List<Map<String , Object>> searchTableData(String tableName) throws Exception;
}
