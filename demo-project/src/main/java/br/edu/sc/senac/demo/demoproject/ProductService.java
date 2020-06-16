package br.edu.sc.senac.demo.demoproject;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public final class ProductService {

	private static final ProductDTO[] DEFAULT_PRODUCTS = new ProductDTO[] {
			new ProductDTO(Long.valueOf(0), "Phone XL", "A large phone with one of the best screens", Double.valueOf(799)),
			new ProductDTO(Long.valueOf(0), "Phone Mini", "A great phone with one of the best cameras", Double.valueOf(699)),
			new ProductDTO(Long.valueOf(0), "Phone Standard", "", Double.valueOf(299)) };

	private final ProductController productController;

	ProductService(final ProductController productController) {
		this.productController = productController;
		Arrays.asList(ProductService.DEFAULT_PRODUCTS).forEach(dto -> this.productController.insertProduct(dto));
	}

	@GetMapping("/list")
	public List<ProductDTO> list() {
		return this.productController.getAllProducts();
	}

	@GetMapping("/{id}/details")
	//A classe ResponseEntity encapsula o objeto, que é o ProductDTO, retornado como status Ok ou status not foud
	//Temos que istanciar a classe ResponseEntity e retornar um objeto dela, que é product
	//A classe ResponseEntity pra dizer qual tipo de status queremos mandar para o usuário
	public ResponseEntity<ProductDTO> getProduct(@PathVariable final Long id) {
		final ProductDTO product = this.productController.getProduct(id);
		if (product.equals(ProductDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ProductDTO> removeProduct(@PathVariable final Long id) {
		final ProductDTO removedProduct = this.productController.removeProduct(id);
// 		A linha comentada do if é a mesma da linha 57 a 59, porém a linha comentada
//		é a forma mais correta de implementação se um objeto é nulo ou não
//		o .equals método para comparar se dois objetos são iguais
//		Se aquele objeto que retornou da ProductController for null value ele vai ser
//		iquals e sendo iquals entra dentro do método
		
		if (removedProduct.equals(ProductDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
//		Esse removedProduct == null é uma má forma de programação, pois a chance de esconder
//		um bug é alto, se o objeto for nulo por algum bug esse código está escondendo
//		removendo esse bug. Por isso ao invés do remove product retornar nulo
//		ele vai retornar um objeto que representa o objeto nulo. Na constante NULL_VALUE(estático)
//		os parâmetros que estão sendo passados no construtor são valores nulos -> (""),(0)
//		não tem valores, está sendo criado uma referencia de um objeto productDTO, 
//		dizendo que este objeto vai representar um objeto nulo
		
		//if (id >= clients.size());
		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//}
		//if (id < 0) {
		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		//}
		
		//if(id > -1 && id < client.size());
		
//		if (removedProduct == null) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
			
		return new ResponseEntity<>(removedProduct, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable final Long id, @RequestBody final ProductDTO product) {
		final ProductDTO oldProduct = this.productController.updateProduct(id, product);
		if (oldProduct.equals(ProductDTO.NULL_VALUE)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(oldProduct, HttpStatus.OK);
	}

	@PostMapping
	public Long insertProduct(@RequestBody final ProductDTO product) {
		return this.productController.insertProduct(product);
	}

}
