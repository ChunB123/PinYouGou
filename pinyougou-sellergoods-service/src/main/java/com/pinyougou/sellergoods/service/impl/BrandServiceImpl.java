package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author YaphetS
 * @date 2018/10/10 4:01 PM
 */
@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper brandMapper;

	@Override
	public List<TbBrand> findAll() {
		return brandMapper.selectByExample(null);
	}

	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		//使用MyBatis的pageHelper插件
		PageHelper.startPage(pageNum,pageSize);
		Page<TbBrand> page=(Page<TbBrand>)brandMapper.selectByExample(null);
		System.out.println("service1");
		return new PageResult(page.getTotal(),page.getResult());
	}

	@Override
	public void add(TbBrand tbBrand) {


		brandMapper.insert(tbBrand);
	}

	@Override
	public TbBrand findOne(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(TbBrand tbBrand) {
		brandMapper.updateByPrimaryKey(tbBrand);
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			brandMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public PageResult findPage(TbBrand tbBrand, int pageNum, int pageSize) {
		//使用MyBatis的pageHelper插件
		PageHelper.startPage(pageNum,pageSize);
		TbBrandExample tbBrandExample=new TbBrandExample();
		TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();
		if(tbBrand!=null){
			if(tbBrand.getName()!=null&&tbBrand.getName().length()>0){
				criteria.andNameLike("%"+tbBrand.getName()+"%");
			}
			if(tbBrand.getFirstChar()!=null&&tbBrand.getFirstChar().length()>0){
				criteria.andFirstCharEqualTo(tbBrand.getFirstChar());
			}
		}
		Page<TbBrand> page=(Page<TbBrand>)brandMapper.selectByExample(tbBrandExample);
		System.out.println("service1");
		return new PageResult(page.getTotal(),page.getResult());

	}

	@Override
	public List<Map> selectOptionList() {
		return brandMapper.selectOptionList();
	}
}
