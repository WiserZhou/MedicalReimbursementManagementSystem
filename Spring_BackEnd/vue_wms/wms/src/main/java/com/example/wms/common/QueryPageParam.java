package com.example.wms.common;

import lombok.Data;

import java.util.HashMap;

@Data
public class QueryPageParam {
    private static int PAGE_SIZE = 10;
    private static int PAGE_NO = 1;
    private int pageNo = PAGE_NO;
    private int pageSize = PAGE_SIZE;

    private HashMap param = new HashMap();

}
