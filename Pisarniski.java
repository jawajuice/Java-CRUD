import java.io.*;
import java.util.*;

public class Pisarniski extends Delavec
{
	public int stNadst;
	public int stIndet;

	public Pisarniski()
	{
		this.stNadst = 0;
		this.stIndet = 0;
	}
	public Pisarniski (int stNadst, int stIndet)
	{
		this.stNadst = stNadst;
		this.stIndet = stIndet;
	}
	public Pisarniski (int n, int in, String i, int mst, String dr, double d)
	{
		super(i, mst, dr, d);
		this.stNadst = n;
		this.stIndet = in;

	}

	public int getStNadst()
	{
		return this.stNadst;
	}
	public int getStIndet()
	{
		return this.stIndet;
	}
	public void setStNadst(int na)
	{
		this.stNadst = na;
	}
	public void setStIndet(int ind)
	{
		this.stIndet = ind;
	}

	public String toString()
	{
		String opis="";
		opis += super.toString();

		opis+= "Številka nadstropja: " + this.stNadst + ".\n";
		opis+= "Številka indentifikacije: " + this.stIndet + ".\n";

		return opis;
	}

	public static Pisarniski vnesiDelavca() throws Exception
	{
		BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("*****   Vnos novega pisarniškega delavca:   *****");
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
		Pisarniski novDelavec = new Pisarniski(n,in,i,mst,dr,d);

		return novDelavec;
	}
	public String shraniKotNiz()
	{
		String vpis = "*P\r\n";
		vpis += this.getIme() + "\r\n";
		vpis += this.getMaticnaSt() + "\r\n";
		vpis += this.getDatumRojstva() + "\r\n";
		vpis += this.getDohodek() + "\r\n";
		vpis += this.stNadst + "\r\n";
		vpis += this.stIndet + "\r\n";
		vpis += "##\r\n";
		return vpis;
	}
	public static Pisarniski preberiIzNiza(ArrayList<String> zapis)
	{
		Pisarniski delavec = new Pisarniski();
		try
		{
			delavec.setIme(zapis.get(0));
			delavec.setMaticnaSt(Integer.parseInt(zapis.get(1)));
			delavec.setDatumRojstva(zapis.get(2));
			delavec.setDohodek(Double.parseDouble(zapis.get(3)));
			delavec.setStNadst(Integer.parseInt(zapis.get(4)));
			delavec.setStIndet(Integer.parseInt(zapis.get(5)));
			return delavec;
		}
		catch(Exception ex)
		{
			System.out.println("Napaka v zapisu!");
			throw ex;
		}
	}

}