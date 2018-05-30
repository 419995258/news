package com.pb.news.services;

import com.pb.news.entity.News;
import com.pb.news.entity.VO.Message;
import com.pb.news.entity.VO.ResultVo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by pb on 2018/5/22.
 */
public interface INewsService {


    /**
     * 保存临时文件
     * @param file
     * @return
     * @throws Exception
     */
    public Message saveTempFiles(MultipartFile[] file) throws Exception;

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


    /**
     * 
     * @Description: TODO 添加新闻
     * @param    
     * @return 
     * @throws
     * @author pengbin <pengbin>
     * 2018/5/28 18:19
     */
    public Message saveNews(News news) throws Exception;

    /**
     *
     * @Description: TODO 删除新闻
     * @param
     * @return
     * @throws
     * @author pengbin <pengbin>
     * 2018/5/28 18:19
     */
    public Message delNews(News news) throws Exception;


}
