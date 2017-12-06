import java.io.*;
import java.util.*;

public class Delavec
{
	private String ime;
	private int maticnaSt;
	private String datumRojstva;
	private double dohodek;


	public Delavec()
	{
		this.ime = "neznano";
		this.maticnaSt = 0;
		this.datumRojstva = "0";
		this.dohodek = 0;
	}

	public Delavec(String i, int mst, String dr, double d)
	{
		this.ime = i;
		this.maticnaSt = mst;
		this.datumRojstva = dr;
		this.dohodek = d;
	}

	public String getIme()
	{
		return this.ime;
	}

	public int getMaticnaSt()
	{
		return this.maticnaSt;
	}

	public String getDatumRojstva()
	{
		return this.datumRojstva;
	}

	public double getDohodek()
	{
		return this.dohodek;
	}


	public void setIme(String i)
	{
		this.ime = i;
	}

	public void setMaticnaSt(int mst)
	{
		this.maticnaSt = mst;
	}

	public void setDatumRojstva(String dr)
	{
		this.datumRojstva = dr;
	}

	public void setDohodek (double d)
	{
		this.dohodek = d;
	}

	public void izpisiPodatke()
	{
		System.out.println("*****   Podatki delavca   *****");
		System.out.println("Ime in priimek: " + this.getIme() + ",");
		System.out.println("Matična številka delavca: " + this.getMaticnaSt() + ",");
		System.out.println("Datum rojstva: " + this.getDatumRojstva() + ",");
		System.out.println("Dohodek: " + this.getDohodek() + ".");
		System.out.println("********************************");
	}

	public String toString()
	{
		String opis = "";
		opis += "Delavec z imenom: " + this.getIme() + ".\n";
		opis += "Matična številka delavca: " + this.getMaticnaSt() + ".\n";
		opis += "Datum rojstva: " + this.getDatumRojstva() + ".\n";
		opis += "Dohodek: " + this.getDohodek() + " EUR.\n";

		return opis;  // Na koncu vrnemo opis
	}

	// Povozimo še metodo equals, ki jo uporabljamo za primerjanje dveh objektov
	public boolean equals(Object delavec2)
	{
		if(this.maticnaSt == ((Delavec)delavec2).maticnaSt)
			return true;
		else
			return false;
	}
	// Vnos novega delavca
	public static Delavec vnesiDelavca() throws Exception
	{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("*****   Vnos novega delavca:   *****");
			System.out.println(" Vnesite Ime in priimek delavca: ");
			String i = vhod.readLine();
			System.out.println(" Vnesite matično številko delavca: ");
			int mst = Integer.parseInt(vhod.readLine());
			System.out.println(" Vnesite datum rojstva delavca: ");
			String dr = vhod.readLine();
			System.out.println(" Vnesi višino dohodka: ");
			double d = Double.parseDouble(vhod.readLine());
			Delavec novDelavec = new Delavec(i, mst, dr, d);

			return novDelavec;
	}

	public String shraniKotNiz()
	{
		String vpis = "*D\r\n";
		vpis += this.ime + "\r\n";
		vpis += this.maticnaSt + "\r\n";
		vpis += this.datumRojstva + "\r\n";
		vpis += this.dohodek + "\r\n";
		vpis += "##\r\n";
		return vpis;
	}

	public static Delavec preberiIzNiza(ArrayList<String> zapis)
	{
		Delavec delavec = new Delavec();
		try
		{
			delavec.setIme(zapis.get(0));
			delavec.setMaticnaSt(Integer.parseInt(zapis.get(1)));
			delavec.setDatumRojstva(zapis.get(2));
			delavec.setDohodek(Double.parseDouble(zapis.get(3)));
			return delavec;
		}
		catch(Exception ex)
		{
			System.out.println("Napaka v zapisu!");
			throw ex;
		}
	}
}
