package br.com.fiap.view;

import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcularPs;
import br.com.fiap.bo.NotaBOStub.CalcularPsResponse;

public class CalcularPSView {

	public static void main(String[] args) throws Exception {
		//Calcular quanto falta pra PS através do WS
		NotaBOStub stub = new NotaBOStub();
		
		CalcularPs params = new CalcularPs();
		params.setAm(6);
		params.setNac(6);
		
		CalcularPsResponse resp = stub.calcularPs(params);
		
		System.out.println(resp.get_return());
	}
	
}






