package com.fiap.loja.view;

import java.util.Arrays;
import java.util.List;

import com.fiap.loja.EstoqueBOStub;
import com.fiap.loja.EstoqueBOStub.Listar;
import com.fiap.loja.EstoqueBOStub.ListarResponse;
import com.fiap.loja.EstoqueBOStub.ProdutoTO;

public class ListarView {

	public static void main(String[] args) {
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			Listar arg = new Listar();
			ListarResponse resp = stub.listar(arg);
			
			ProdutoTO[] array = resp.get_return();
			
			//Transformar o array em List
			List<ProdutoTO> lista = Arrays.asList(array);
			
			for (ProdutoTO produtoTO : lista) {
				System.out.println(produtoTO.getNome());
				System.out.println(produtoTO.getDescricao());
				System.out.println(produtoTO.getPreco());
				System.out.println("*******************");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}



