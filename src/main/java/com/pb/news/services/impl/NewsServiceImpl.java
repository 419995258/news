package com.pb.news.services.impl;

import com.pb.news.dao.NewsMapper;
import com.pb.news.entity.News;
import com.pb.news.entity.NewsExample;
import com.pb.news.entity.vo.Message;
import com.pb.news.entity.vo.ResultVo;
import com.pb.news.services.NewsService;
import com.pb.news.services.vo.RedisService;
import com.pb.news.util.Basic;
import com.pb.news.util.FileOperationUtil;
import com.pb.news.util.StringContentUtil;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.web.multipart.MultipartFile;

/**
 * Created by pb on 2018/5/22.
 */

@Service
public class NewsServiceImpl extends Basic implements NewsService {


    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private RedisService redisService;

    @Override
    public Message saveTempFiles(MultipartFile[] file) throws Exception {
        Message message = new Message();
        Map<String, Object> fm = new HashMap<String, Object>();

        if (file != null && file.length > 0) {
            // Date createTime = DateUtil.getCurrentDate(DateUtil.DATE_STYLE5);

            for (int i = 0; i < file.length; i++) {
                MultipartFile f = file[i];
                String fileName = f.getOriginalFilename(); // 文件名
                String diskFileName = StringContentUtil.getUuid(); // 保存后的文件名
                CommonsMultipartFile cf = (CommonsMultipartFile) f;
                DiskFileItem fi = (DiskFileItem) cf.getFileItem();
                File f1 = fi.getStoreLocation();
                Message m = FileOperationUtil.saveFileToDisk(f1, fileName,
                        diskFileName, "/static/file/img");

                /*
                 * 返回文件url地址
                 */

                if (m.getSuccess()) {
                    try {
                        fm.put("fileUrl", (String) m.getResult().get("filePath"));
                        message.setSuccess(true);
                        message.setResult(fm);

                        // 删除文件
                        // FileOperationUtil.deleteFile2(path);
                    } catch (Exception e) {
                        Object o = m.getResult().get("savefile");

                        File ef = (File) o;
                        if (ef.exists()) {
                            ef.delete();
                        }
                        throw e;
                    }
                }
            }
        }
        message.setResult(fm);

        return message;
    }

    @Override
    public ResultVo queryNews(ResultVo param) throws Exception {

        ResultVo resultVo = new ResultVo();

        Integer pNum = 1;
        Integer pSize = 10;

        String pageNum = param.getPageNum();
        String pageSize = param.getPageSize();
        if (StringUtils.isNotBlank(pageNum)) {
            pNum = Integer.valueOf(pageNum);
        }
        if (StringUtils.isNotBlank(pageSize)) {
            pSize = Integer.valueOf(pageSize);
        }
        //使用分页插件,核心代码就这一行
        //PageHelper.startPage(pNum, pSize);
        this.setPageInfo(pSize, pNum);

        NewsExample newsExample = new NewsExample();
        newsExample.setOrderByClause("id desc");
        NewsExample.Criteria cr = newsExample.createCriteria();

        //其他条件
        Map<String, Object> query = (HashMap<String, Object>) param.getOther();
        if (query == null) {
            query = new HashMap<String, Object>();
        }
        //删除
        if (StringUtils.isNoneBlank((String) query.get("isDeleted"))) {
            cr.andDelFlagEqualTo(Integer.valueOf((String) query.get("isDeleted")));
        } else {
            cr.andDelFlagEqualTo(0);
        }
        //titile
        if (StringUtils.isNoneBlank((String) query.get("title"))) {
            cr.andTitleLike("%" + query.get("title") + "%");
        }
        //作者
        if (StringUtils.isNoneBlank((String) query.get("source"))) {
            cr.andSourceLike("%" + query.get("source") + "%");
        }


        List<News> newsList = new ArrayList<News>();
        newsList = newsMapper.selectByExample(newsExample);

        this.setReturnPageInfo(pSize, pNum, newsList, resultVo);
        resultVo.setRows(newsList);

        return resultVo;
    }

    @Override
    public Message saveNews(News news) throws Exception {
        Message message = new Message();

        Integer result = newsMapper.insertSelective(news);
        if (result > 0) {
            message.setSuccess(true);
            message.setMessage("保存成功！");
        }
        return message;
    }

    @Override
    public Message delNews(News news) throws Exception {
        Message message = new Message();

        news.setDelFlag(1);
        Integer result = newsMapper.updateByPrimaryKeySelective(news);
        if (result > 0) {
            message.setSuccess(true);
            message.setMessage("删除成功！");
        }
        return message;
    }
}
