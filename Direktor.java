import java.io.*;
import java.util.*;

public class Direktor extends Pisarniski
{
	public String izkusnje;

	public Direktor()
	{
		this.izkusnje = "";
	}
	public Direktor (String z)
	{
		this.izkusnje = z;
	}
	public Direktor (String z,int n, int in, String i, int mst, String dr, double d)
	{
		super(n,in,i, mst, dr, d);
		this.izkusnje = z;

	}

	public String getIzkusnje()
	{
		return this.izkusnje;
	}
	public void setIzkusnje(String z)
	{
		this.izkusnje = z;
	}

	public String toString()
	{
		String opis="";
		opis += super.toString();

		opis+= "Delovne izkušnje: " + this.izkusnje + ".\n";

		return opis;
	}

	public static Direktor vnesiDelavca() throws Exception
	{
		BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("***   Vnos novega pisarniškega delavca:   ***");
		System.out.println(" Vnesite Ime in priimek delavca: ");
		String i = vhod.readLine();
		System.out.println(" Vnesite matično številko delavca: ");
		int mst = Integer.parseInt(vhod.readLine());
		System.out.println(" Vnesite datum rojstva delavca: ");
		String dr = vhod.readLine();
		System.out.println(" Vnesi višino dohodka: ");
		double d = Double.parseDouble(vhod.readLine());
		System.out.println(" Vnesi številko nadstropja: ");
		int n = Integer.parseInt(vhod.readLine());
		System.out.println(" Vnesi številko indentifikacije: ");
		int in = Integer.parseInt(vhod.readLine());
		System.out.println(" Vnesi delovne izkušnje direktorja: ");
		String z = vhod.readLine();
		Direktor novDelavec = new Direktor(z,n,in,i,mst,dr,d);

		return novDelavec;
	}
	public String shraniKotNiz()
	{
		String vpis = "*K\r\n";
		vpis += this.getIme() + "\r\n";
		vpis += this.getMaticnaSt() + "\r\n";
		vpis += this.getDatumRojstva() + "\r\n";
		vpis += this.getDohodek() + "\r\n";
		vpis += this.getStNadst() + "\r\n";
		vpis += this.getStIndet() + "\r\n";
		vpis += this.izkusnje + "\r\n";
		vpis += "##\r\n";
		return vpis;
	}
	public static Direktor preberiIzNiza(ArrayList<String> zapis)
	{
		Direktor delavec = new Direktor();
		try
		{
			delavec.setIme(zapis.get(0));
			delavec.setMaticnaSt(Integer.parseInt(zapis.get(1)));
			delavec.setDatumRojstva(zapis.get(2));
			delavec.setDohodek(Double.parseDouble(zapis.get(3)));
			delavec.setStNadst(Integer.parseInt(zapis.get(4)));
			delavec.setStIndet(Integer.parseInt(zapis.get(5)));
			delavec.setIzkusnje(zapis.get(6));
			return delavec;
		}
		catch(Exception ex)
		{
			System.out.println("Napaka v zapisu!");
			throw ex;
		}
	}

}