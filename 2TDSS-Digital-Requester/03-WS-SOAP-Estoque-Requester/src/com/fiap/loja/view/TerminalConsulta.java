package com.fiap.loja.view;

import java.util.Scanner;

import com.fiap.loja.EstoqueBOStub;
import com.fiap.loja.EstoqueBOStub.ConsultarProduto;
import com.fiap.loja.EstoqueBOStub.ConsultarProdutoResponse;
import com.fiap.loja.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			
			ConsultarProduto params = new ConsultarProduto();
			System.out.println("Digite o código: ");
			params.setCodigo(sc.nextInt());
			
			ConsultarProdutoResponse resp = 
								stub.consultarProduto(params);
			
			ProdutoTO to = resp.get_return();
			System.out.println(to.getCodigo());
			System.out.println(to.getNome());
			System.out.println(to.getDescricao());
			System.out.println(to.getPreco());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
	
}
