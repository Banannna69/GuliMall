package com.gulimall.product.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.gulimall.common.valid.AddGroup;
import com.gulimall.common.valid.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gulimall.product.entity.BrandEntity;
import com.gulimall.product.service.BrandService;
import com.gulimall.common.utils.PageUtils;
import com.gulimall.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author Banana69
 * @email junminn@126.com
 * @date 2023-02-10 21:45:34
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
        public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
        public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
        public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand){
        //if(result.hasErrors()){
        //    Map<String,String> map = new HashMap<String,String>();
        //    // 获取校验的错误结果
        //    result.getFieldErrors().forEach((item) ->{
        //        // 获取错误提示
        //        String defaultMessage = item.getDefaultMessage();
        //        // 获取错误名字
        //        String field = item.getField();
        //        map.put(field, defaultMessage);
        //    });
        //
        //   return R.error(400,"品牌名称为空").put("data",map);
        //
        //}else{
        //    brandService.save(brand);
        //}

        brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update/status")
        public R updateStatus(@RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated({UpdateGroup.class})  @RequestBody BrandEntity brand){
        brandService.updateById(brand);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
        public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
