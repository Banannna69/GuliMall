package com.banana69.thirdParty;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import net.sf.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

class GulimallThirdPartyApplicationTests {


    @Resource
    OSSClient ossClient;


    @Test
    void contextLoads() throws FileNotFoundException {
        InputStream inputStream = new FileInputStream("/Users/null/Downloads/1.jpg");
        ossClient.putObject("banana69-guli","haha.jpg",inputStream);
        ossClient.shutdown();
        System.out.println("上传完成");
    }

    @Test
    protected void test(){
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        System.out.println(format);


    }




}
