package fafica.pi.projeto.teste;

import fafica.pi.projeto.entidades.Produto;
import fafica.pi.projeto.jdbc.ProdutoDao;

public class TesteProdutoDao {

	public static void main(String[] args) {
		
		Produto produto = new Produto();
		produto.setNome("Produto");
		produto.setPreco(50.00);
		
		ProdutoDao prod = new ProdutoDao();
		prod.cadastrar(produto);
		
	}

}
