package negozioLogika;

import gui.*;

public class Jaurtitzaile {

	public static void main(String[] args) {
		Aurkezpena3 a=new Aurkezpena3();
		Login2 l=new Login2();
		a.setNeogozioLogica(l);
		a.setVisible(true);
	}

}
