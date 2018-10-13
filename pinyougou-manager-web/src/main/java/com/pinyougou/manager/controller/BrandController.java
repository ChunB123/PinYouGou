package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author YaphetS
 * @date 2018/10/10 4:07 PM
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;

	/**
	 * 返回全部列表 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}

	/**
	 * 返回带分页的列表
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int pageNum,int pageSize){
		return brandService.findPage(pageNum,pageSize);
	}

	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand tbBrand){
		try{
			brandService.add(tbBrand);
			return new Result(true,"添加成功");
		}catch (Exception e){
			return new Result(false,"添加失败");
		}

	}

	@RequestMapping("/findOne")
	public TbBrand findOne(Long id){
		return brandService.findOne(id);
	}

	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand tbBrand){
		try{
			brandService.update(tbBrand);
			return new Result(true,"修改成功");
		}catch (Exception e){
			return new Result(false,"修改失败");
		}

	}

	@RequestMapping("/delete")
	public Result delete(Long[] ids){
		try{
			brandService.delete(ids);
			return new Result(true,"删除成功");
		}catch (Exception e){
			return new Result(false,"删除失败");
		}

	}

	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand tbBrand,int pageNum,int pageSize){
		return brandService.findPage(tbBrand,pageNum,pageSize);
	}

}
