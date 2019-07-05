package app.future.web.handler;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import app.future.commons.base.BaseController;
import app.future.commons.bean.Brand;
import app.future.commons.services.IBrandService;


@Controller
@RequestMapping("brand")
public class BrandController extends BaseController {

	@Autowired
	private IBrandService brandService;
	
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("index.html")
	public String show(){
		return "brand" ;
	}
	
	@RequestMapping("/find.html")
	@ResponseBody
	public List<Brand> find(Brand bean){
		List<Brand> list = null;
		try {
			list = brandService.find(bean);
		} catch (Exception e) {
			putFailedData("查询品牌列表出错！", e);
		}
		return list;
	}
	

	
}
