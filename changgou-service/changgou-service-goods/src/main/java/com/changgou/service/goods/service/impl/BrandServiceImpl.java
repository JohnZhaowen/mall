package com.changgou.service.goods.service.impl;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.goods.dao.BrandMapper;
import com.changgou.service.goods.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(int id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(int id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example = getExample(brand);
        return brandMapper.selectByExample(example);
    }

    private Example getExample(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();

        if(brand != null){
            if(StringUtils.isNotBlank(brand.getName())){
                criteria.andLike("name", "%" + brand.getName() + "%");
            }

            if(StringUtils.isNotBlank(brand.getLetter())){
                criteria.andEqualTo("letter", brand.getLetter());
            }
        }
        return example;
    }

    @Override
    public PageInfo<Brand> findPage(int page, int size) {

        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.selectAll();
        return new PageInfo<>(brands);
    }

    @Override
    public PageInfo<Brand> findPage(Brand brand, int page, int size) {

        PageHelper.startPage(page, size);
        Example example = getExample(brand);
        List<Brand> brands = brandMapper.selectByExample(example);

        return new PageInfo<>(brands);
    }
}
