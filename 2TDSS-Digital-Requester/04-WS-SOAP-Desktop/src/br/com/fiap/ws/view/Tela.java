package br.com.fiap.ws.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.repository.NotaRepository;

import java.rmi.RemoteException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shlFiap;
	private Text txtAm;
	private Text txtNac;
	private Text txtPs;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFiap.open();
		shlFiap.layout();
		while (!shlFiap.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFiap = new Shell();
		shlFiap.setSize(244, 277);
		shlFiap.setText("FIAP");
		
		txtAm = new Text(shlFiap, SWT.BORDER);
		txtAm.setBounds(81, 27, 76, 21);
		
		Label lblAm = new Label(shlFiap, SWT.NONE);
		lblAm.setBounds(10, 30, 55, 15);
		lblAm.setText("AM");
		
		Label lblNac = new Label(shlFiap, SWT.NONE);
		lblNac.setBounds(10, 61, 55, 15);
		lblNac.setText("NAC");
		
		txtNac = new Text(shlFiap, SWT.BORDER);
		txtNac.setBounds(81, 58, 76, 21);
		
		Button btnCalcular = new Button(shlFiap, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Clique do botão
				float am = Float.parseFloat(txtAm.getText());
				float nac = Float.parseFloat(txtNac.getText());
				try {
					NotaRepository rep = new NotaRepository();
					float ps = rep.calcularPs(am, nac);
					txtPs.setText(String.valueOf(ps));
				}catch(RemoteException re) {
					txtPs.setText("Erro ao chamar o ws");
				}
			}
		});
		btnCalcular.setBounds(81, 93, 75, 25);
		btnCalcular.setText("Calcular");
		
		txtPs = new Text(shlFiap, SWT.BORDER);
		txtPs.setBounds(81, 136, 76, 21);
		
		Label lblPs = new Label(shlFiap, SWT.NONE);
		lblPs.setBounds(10, 142, 55, 15);
		lblPs.setText("PS");

	}
}
