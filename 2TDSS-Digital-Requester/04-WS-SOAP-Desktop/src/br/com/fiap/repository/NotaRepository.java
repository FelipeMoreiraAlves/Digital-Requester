package br.com.fiap.repository;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcularPs;
import br.com.fiap.bo.NotaBOStub.CalcularPsResponse;

//Classe para acessar o web service
public class NotaRepository {

	private NotaBOStub stub;
	
	public NotaRepository() throws AxisFault {
		stub = new NotaBOStub();
	}
	
	public float calcularPs(float am, float nac) throws RemoteException {
		CalcularPs valores = new CalcularPs();
		valores.setAm(am);
		valores.setNac(nac);
		
		CalcularPsResponse resp = stub.calcularPs(valores);
		
		return resp.get_return();
	}
	
	
}



