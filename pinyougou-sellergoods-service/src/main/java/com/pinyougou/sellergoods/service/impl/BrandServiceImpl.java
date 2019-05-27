package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;


@Service
public class BrandServiceImpl implements BrandService {
	
	
	@Autowired
	private TbBrandMapper brandMapper;

	
	
	@Override
	public PageResult findPage(int pageNum, int pageSize, TbBrand brand) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbBrandExample example = new TbBrandExample();
		Criteria criteria = example.createCriteria();
		if(brand!=null) {
			
			if(brand.getName()!=null&&brand.getName().length()>0) {
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if(brand.getFirstChar()!=null&&brand.getFirstChar().length()>0) {
				criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
			}
		}
		
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(example);
		
		return new PageResult(page.getTotal(),page.getResult());
	}

	/**
	 * 根据品牌id删除品牌
	 */
	@Override
	public void delete(Long[] ids) {	
			for (Long id: ids) {
				brandMapper.deleteByPrimaryKey(id);
			}

	}

	/**
	 * 更新品牌信息
	 */
	
	@Override
	public void update(TbBrand brand) {
		
			brandMapper.updateByPrimaryKey(brand);
	
	}

	/**
	 * 点击修改时，显示当前的信息
	 */
	@Override
	public TbBrand findOne(Long id) {
		
		return brandMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加品牌信息
	 */
	
	@Override
	public void add(TbBrand brand) {
	
			brandMapper.insert(brand);
	
		
	}

	/**
	 * 分页查询
	 * pageNum是当前页
	 * pageSize是每页展示的记录数
	 */
	@Override
	public PageResult findPage(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page =(Page<TbBrand>) brandMapper.selectByExample(null);
		return new PageResult(page.getTotal(),page.getResult());
	}

	/**
	 * 查询所有记录
	 */

	public List<TbBrand> findAll() {
		// TODO Auto-generated method stub
		return brandMapper.selectByExample(null);
	}

}
