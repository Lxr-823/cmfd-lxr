package com.baizhi.serviceImpl;

import com.baizhi.dao.AlbumDao;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Map<String, Object> queryAll(Integer rows, Integer page) {
     Integer start  = (page-1)*rows;
        List<Album> albums = albumDao.queryAll(start, rows);
        //总条数
        Integer count = albumDao.selectCount();

        Integer tatopage = count%rows==0 ? count/rows : count/rows+1;
        Map<String, Object> map = new HashMap<>();
        map.put("page",page);
        map.put("rows",albums);
        map.put("total",tatopage);
        map.put("records",count);
        return  map;
    }
}
