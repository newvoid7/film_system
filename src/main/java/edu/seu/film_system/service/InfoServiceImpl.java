package edu.seu.film_system.service;

import edu.seu.film_system.mapper.InfoMapper;
import edu.seu.film_system.pojo.Info;
import edu.seu.film_system.pojo.ResultDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Override
    public ResultDTO<Info> findAllInfo2() {
        ResultDTO<Info> resultDTO = new ResultDTO<>();
        List<Info> data = new ArrayList<>();
        data = infoMapper.findAllInfo();
        resultDTO.setData(data);
        resultDTO.setCode(6);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Info> findInfoByKeyWord(String keyWord) {
        ResultDTO<Info> resultDTO = new ResultDTO<>();
        List<Info> data = new ArrayList<>();
        data = infoMapper.findInfoByKeyWord(keyWord);
        resultDTO.setData(data);
        resultDTO.setCode(6);
        resultDTO.setMsg("success");
        return resultDTO;
    }

    @Override
    public ResultDTO<Info> findInfoByInfo(Info info) {
        ResultDTO<Info> resultDTO = new ResultDTO<>();
        List<Info> data = new ArrayList<>();
        data = infoMapper.findInfoByInfo(info);
        resultDTO.setData(data);
        resultDTO.setCode(6);
        resultDTO.setMsg("多条件查询");
        return resultDTO;
    }

    @Override
    public ResultDTO<Info> addInfo(Info info) {
        ResultDTO<Info> resultDTO = new ResultDTO<>();
        try{
            int i = infoMapper.addInfo(info);
            if (i > 0) {
               resultDTO.setMsg("注册成功！");
            } else {
                resultDTO.setMsg("注册失败！");
            }
        } catch (Exception e) {
            resultDTO.setMsg("注册失败！");
        }
        // 如果希望注册成功则立即登录，可能需要查询一次，那么可以在该业务中查询用户
        return resultDTO;
    }
}
