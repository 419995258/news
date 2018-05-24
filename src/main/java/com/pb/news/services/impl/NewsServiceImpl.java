package com.pb.news.services.impl;

import com.github.pagehelper.PageHelper;
import com.pb.news.dao.NewsMapper;
import com.pb.news.entity.News;
import com.pb.news.entity.NewsExample;
import com.pb.news.entity.VO.ResultVo;
import com.pb.news.services.INewsService;
import com.pb.news.services.vo.RedisService;
import com.pb.news.util.FengYeBasic;
import com.pb.news.util.ObjectUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pb on 2018/5/22.
 */

@Service
public class NewsServiceImpl  extends FengYeBasic implements INewsService{


    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public ResultVo queryNews(ResultVo param) throws Exception {

        ResultVo resultVo = new ResultVo();

        Integer pNum = 1;
        Integer pSize = 10;

        String pageNum = param.getPageNum();
        String pageSize = param.getPageSize();
        if(StringUtils.isNotBlank(pageNum)){
            pNum = Integer.valueOf(pageNum);
        }
        if(StringUtils.isNotBlank(pageSize)){
            pSize = Integer.valueOf(pageSize);
        }
        //使用分页插件,核心代码就这一行
        //PageHelper.startPage(pNum, pSize);
        this.setPageInfo(pSize,pNum);

        NewsExample newsExample = new NewsExample();
        newsExample.setOrderByClause("id desc");
        NewsExample.Criteria cr = newsExample.createCriteria();
        cr.andDelFlagEqualTo(0);


        List<News> newsList = new ArrayList<News>();
        newsList = newsMapper.selectByExample(newsExample);

        this.setReturnPageInfo(pSize,pNum,newsList,resultVo);
        resultVo.setRows(newsList);

        return resultVo;
    }
}
