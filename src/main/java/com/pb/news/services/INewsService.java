package com.pb.news.services;

import com.pb.news.entity.VO.ResultVo;

/**
 * Created by pb on 2018/5/22.
 */
public interface INewsService {


    /**
     *
     * @Description: TODO 查询新闻数据
     * @param    
     * @return 
     * @throws
     * @author pengbin <pengbin>
     * 2018/5/22 17:13
     */
    public ResultVo queryNews(ResultVo param) throws Exception;


}
