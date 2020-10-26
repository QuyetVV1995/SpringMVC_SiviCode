package DiamonShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.ProductsDto;

@Service
public interface ICatelogyService {
	public List<ProductsDto> getDataProductsPaginate(int id,int start, int end);
	public List<ProductsDto> getAllProductsByID(int id);
}
