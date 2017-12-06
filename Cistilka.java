import java.io.*;
import java.util.*;

public class Cistilka extends Fizicni
{
	int stUrMesecno;

	public Cistilka()
	{
		this.stUrMesecno = 0;
	}
	public Cistilka(int u)
	{
		this.stUrMesecno = u;
	}
	public Cistilka (int u, int n, int in, String i, int mst, String dr, double d)
	{
		super(n,in,i,mst,dr,d);
		this.stUrMesecno = u;

	}

	public int getStUrMesecno()
	{
		return this.stUrMesecno;
	}
	public void setStUrMesecno(int u)
	{
		this.stUrMesecno = u;
	}
	public String toString()
	{
		String opis="";
		opis += super.toString();
		opis+= "Število ur mesečno: " + this.stUrMesecno + ".\n";
		return opis;
	}

	public static Cistilka vnesiDelavca() throws Exception
	{
		BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("***   Vnos nove čistilke:   ***");
		System.out.println(" Vnesite Ime in priimek delavca: ");
		String i = vhod.readLine();
		System.out.println(" Vnesite matièno številko delavca: ");
		int mst = Integer.parseInt(vhod.readLine());
		System.out.println(" Vnesite datum rojstva delavca: ");
		String dr = vhod.readLine();
		System.out.println(" Vnesi višino dohodka: ");
		double d = Double.parseDouble(vhod.readLine());
		System.out.println(" Vnesi številko obleke: ");
		int n = Integer.parseInt(vhod.readLine());
		System.out.println(" Vnesi številko cevljev: ");
		int in = Integer.parseInt(vhod.readLine());
		System.out.println(" Vnesi število ur mesečno: ");
		int u = Integer.parseInt(vhod.readLine());
		Cistilka novDelavec = new Cistilka(u,n,in,i,mst,dr,d);
		return novDelavec;
	}
	public String shraniKotNiz()
	{
		String vpis = "*C\r\n";
		vpis += this.getIme() + "\r\n";
		vpis += this.getMaticnaSt() + "\r\n";
		vpis += this.getDatumRojstva() + "\r\n";
		vpis += this.getDohodek() + "\r\n";
		vpis += this.getStObleke() + "\r\n";
		vpis += this.getStCevljev() + "\r\n";
		vpis += this.stUrMesecno + "\r\n";
		vpis += "##\r\n";
		return vpis;
	}
	public static Cistilka preberiIzNiza(ArrayList<String> zapis)
	{
		Cistilka delavec = new Cistilka();
		try
		{
			delavec.setIme(zapis.get(0));
			delavec.setMaticnaSt(Integer.parseInt(zapis.get(1)));
			delavec.setDatumRojstva(zapis.get(2));
			delavec.setDohodek(Double.parseDouble(zapis.get(3)));
			delavec.setStObleke(Integer.parseInt(zapis.get(4)));
			delavec.setStCevljev(Integer.parseInt(zapis.get(5)));
			delavec.setStUrMesecno(Integer.parseInt(zapis.get(6)));
			return delavec;
		}
		catch(Exception ex)
		{
			System.out.println("Napaka v zapisu!");
			throw ex;
		}
	}

}