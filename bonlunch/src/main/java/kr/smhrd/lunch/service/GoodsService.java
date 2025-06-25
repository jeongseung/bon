package kr.smhrd.lunch.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.smhrd.lunch.dto.GoodsDto;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import kr.smhrd.lunch.repository.GoodsDetailRepository;
import kr.smhrd.lunch.repository.GoodsRepository;

@Service
public class GoodsService {

	@Autowired
	GoodsRepository goodsRepository;
	@Autowired
	GoodsDetailRepository goodsDetailRepository;

	public List<GoodsDto> getAllGoods() {
		
	
		List<Goods> resultList = goodsRepository.findAll();
		List<GoodsDto> returnList = new  ArrayList<GoodsDto>();
		
		for(Goods goods : resultList) {
			GoodsDto goodsDto = new GoodsDto();
			goodsDto.setId(goods.getId());
			goodsDto.setIsBest(goods.getIsBest());
			goodsDto.setIsNew(goods.getIsNew());
			goodsDto.setMain_thumb(goods.getMain_thumb());
			goodsDto.setName(goods.getName());
			goodsDto.setPrice(goods.getPrice());
			returnList.add(goodsDto);
		}
		
		System.out.println(returnList.toString());
		return returnList;
		
	}

	public GoodsDto getGoodsDetail(int id) {
		
		//1. id값을 가지고 제품 정보 Goods 가지고 오기!
		Goods goods = goodsRepository.findById(id).orElse(null);
		GoodsDetail detail = goodsDetailRepository.findById(id).orElse(null);
		
		//2. 두 변수의 값이 null인 경우에는 null을 리턴
		if(goods == null || detail == null) {
			return null;
		}
		
		GoodsDto dto = new GoodsDto();
		dto.setId(goods.getId());
		dto.setPrice(goods.getPrice());
		dto.setName(goods.getName());
		dto.setIsNew(goods.getIsNew());
		dto.setIsBest(goods.getIsBest());
		dto.setMain_thumb(goods.getMain_thumb());
		dto.setDetail(detail);
		
		return dto;
		
		
	}

}
