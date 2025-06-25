package kr.smhrd.lunch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kr.smhrd.lunch.dto.GoodsDto;
import kr.smhrd.lunch.repository.GoodsRepository;
import kr.smhrd.lunch.service.GoodsService;

@CrossOrigin(origins = "http://3.25.124.94:5173")
@RestController
@RequestMapping("/api")
public class GoodsController {

	@Autowired
	GoodsService goodsService;
	
	@Autowired
	GoodsRepository goodsRepository;

	@GetMapping("/goods_list")
	public List<GoodsDto> getGoodsList() {
		System.out.println("[list 출력 컨트롤러]");
		
		// 2step -> Service -> Repository
		List<GoodsDto> result = goodsService.getAllGoods();
		return result;
		
	}
	
	@GetMapping("/goods_list/{id}")
	public GoodsDto getGoodsDetail(@PathVariable("id") int id) {
		System.out.println(id);
		
		GoodsDto goodsDetail = goodsService.getGoodsDetail(id);

		
		return goodsDetail;
	}
}



