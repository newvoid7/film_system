package edu.seu.film_system.service;

import edu.seu.film_system.mapper.InfoMapper;
import edu.seu.film_system.pojo.Info;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("infoService")
@Transactional
public class InfoServiceImpl implements InfoService {
    @Resource
    InfoMapper infoMapper;

    @Override
    public List<Info> findAllInfo() {
        // 查之前如果有其它业务，可以在此编写
        return infoMapper.findAllInfo();
    }
}
