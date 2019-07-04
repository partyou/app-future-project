package app.future.web.handler;


import app.futrue.commons.base.BaseController;
import app.futrue.commons.base.PageModel;
import app.futrue.commons.bean.Brand;
import app.futrue.commons.services.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


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
	
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("show.html")
	public String show(Brand bean, ModelMap modelMap){
		try {
			List<Brand> list = brandService.find(bean);
			modelMap.put("brandList", list);
		} catch (Exception e) {
			putFailedData("查询品牌列表出错！", e);
		}
		return "brand";
	}
	
	/**
	 * 页面跳转
	 * @return
	 */
	@RequestMapping("content.html")
	public String content(Brand bean, PageModel model, ModelMap modelMap){
		try {
			Map<String, Object> page = brandService.findByPage(bean,model);
			modelMap.put("page", page);
			modelMap.put("name", "jojo");
//			modelMap.addAttribute("page", page);
		} catch (Exception e) {
			putFailedData("查询品牌列表出错！", e);
		}
		return "/xjb/common/content.ftl";
	}
	
	@RequestMapping("/findByPage.html")
	@ResponseBody
	public Map<String, Object> findByPage(Brand bean,PageModel model) throws Exception{
//		try {
//			putSuccessData();
//		} catch (Exception e) {
//			putFailedData("查询品牌列表出错！", e);
//		}
		return brandService.findByPage(bean,model);
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
	
	/**
	 * 删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete.html")
	@ResponseBody
	public Map<String,Object> delete(Short id){
		try {
			int result = brandService.delete(id);
			putSuccessData(result);
		} catch (Exception e) {
			putFailedData("删除记录失败！", e);
		}
		return resultMap;
	}
	/**
	 * 保存信息
	 * @param bean
	 * @return
	 */
	@RequestMapping("/save.html")
	@ResponseBody
	public Map<String,Object> save(Brand bean){
		try {
			int result = brandService.insert(bean);
			putSuccessData(result);
		} catch (Exception e) {
			putFailedData("保存记录失败！", e);
		}
		return resultMap;
	}
	/**
	 * 更新信息
	 * @param bean
	 * @return
	 */
	@RequestMapping("/update.html")
	@ResponseBody
	public Map<String,Object> update(Brand bean){
		try {
			int result = brandService.update(bean);
			putSuccessData(result);
		} catch (Exception e) {
			putFailedData("更新记录失败！", e);
		}
		return resultMap;
	}
	
}
