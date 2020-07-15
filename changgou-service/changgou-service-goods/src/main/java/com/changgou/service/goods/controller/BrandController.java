package com.changgou.service.goods.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.goods.service.BrandService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand, @PathVariable(value = "page") int page, @PathVariable(value = "size") int size){
        int error = 10 / 0;

        PageInfo<Brand> brands = brandService.findPage(brand, page, size);
        return new Result<>(true, StatusCode.OK, "条件分页查询品牌成功", brands);
    }

    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page") int page, @PathVariable(value = "size") int size){
        PageInfo<Brand> brands = brandService.findPage(page, size);
        return new Result<>(true, StatusCode.OK, "分页查询品牌成功", brands);
    }

    @PostMapping("/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        List<Brand> brands = brandService.findList(brand);
        return new Result<>(true, StatusCode.OK, "条件查询品牌成功", brands);
    }

    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> allBrands = brandService.findAll();
        return new Result<>(true, StatusCode.OK, "查询品牌集合成功", allBrands);
    }

    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id") int id){
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "根据Id查询品牌成功", brand);
    }

    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result<>(true, StatusCode.OK, "增加品牌成功");
    }

    @PutMapping
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result<>(true, StatusCode.OK, "修改品牌成功");
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") int id){
        brandService.delete(id);
        return new Result<>(true, StatusCode.OK, "删除品牌成功");
    }

}
