package br.com.fiap.ws.view;

import java.util.Scanner;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleView {

	public static void main(String[] args) throws Exception {
		//Chamar o ws dos correios
		Scanner sc = new Scanner(System.in);
		
		//4014 -> SEDEX
		CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
		
		CalcPrazo params = new CalcPrazo();
		params.setNCdServico("4014");
		System.out.println("CEP de Origem");
		params.setSCepOrigem(sc.next() + sc.nextLine());
		System.out.println("CEP de Destino");
		params.setSCepDestino(sc.next() + sc.nextLine());
		
		CalcPrazoResponse resp = stub.calcPrazo(params);
		
		//Recuperar a resposta
		String data = resp.getCalcPrazoResult().getServicos()
			.getCServico()[0].getDataMaxEntrega();
		
		System.out.println(data);
		
		
		sc.close();
	}
	
}
