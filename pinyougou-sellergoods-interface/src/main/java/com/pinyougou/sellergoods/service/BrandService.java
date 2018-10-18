package com.pinyougou.sellergoods.service;

import java.util.List;
import java.util.Map;

import com.pinyougou.pojo.TbBrand;
import entity.PageResult;

/**
 * 品牌接口
 * @author Administrator
 *
 */
public interface BrandService {

	List<TbBrand> findAll();

	PageResult findPage(int pageNum,int pageSize);

	void add(TbBrand tbBrand);

	TbBrand findOne(Long id);

	void update(TbBrand tbBrand);

	void delete(Long[] ids);

	PageResult findPage(TbBrand tbBrand,int pageNum,int pageSize);

	/**
	 * 品牌下拉框数据
	 * @return
	 */
	List<Map> selectOptionList();
}
