package com.gulimall.product;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gulimall.product.entity.BrandEntity;
import com.gulimall.product.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class GulimallProductApplicationTests {

	@Autowired
	private BrandService brandService;

	@Test
	void contextLoads() {
		//BrandEntity brand = new BrandEntity();
		//brand.setName("华为");
		//brandService.save(brand);
		//System.out.println("保存成功");


		List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 13));

		log.info(list.toString());

	}

}
