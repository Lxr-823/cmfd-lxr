package com.baizhi.service;

import java.util.Map;

public interface AlbumService {
    //分页
    public Map<String,Object> queryAll(Integer rows, Integer page);
}
