import java.io.*;
import java.util.*;

public class Fizicni extends Delavec
{
	private int stObleke;
	private int stCevljev;

	public Fizicni()
	{
		super("Neznano", 0, "0", 0);
		this.stObleke = 52;
		this.stCevljev = 44;

	}

	public Fizicni(int n, int in)
	{
		super("Neznano", 0, "0", 0);
		this.stObleke = n;
		this.stCevljev = in;

	}
	public Fizicni(int n, int in, String i, int mst, String dr, double d)
	{
		super(i, mst, dr, d);
		this.stObleke = n;
		this.stCevljev = in;

	}

	public int getStObleke()
	{
		return this.stObleke;
	}
	public int getStCevljev()
	{
		return this.stCevljev;
	}
	public void setStObleke(int st)
	{
		this.stObleke = st;
	}
	public void setStCevljev(int st)
	{
		this.stCevljev = st;
	}

	public String toString()
	{
		String opis="";
		opis += super.toString();

		opis+= "Številka obleke: " + this.stObleke + ".\n";
		opis+= "Številka cevljev: " + this.stCevljev + ".\n";

		return opis;
	}

	public static Fizicni vnesiDelavca() throws Exception
		{
				BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("*****   Vnos novega fizicnega delavca:   *****");
				System.out.println(" Vnesite Ime in priimek delavca: ");
				String i = vhod.readLine();
				System.out.println(" Vnesite matično številko delavca: ");
				int mst = Integer.parseInt(vhod.readLine());
				System.out.println(" Vnesite datum rojstva delavca: ");
				String dr = vhod.readLine();
				System.out.println(" Vnesi višino dohodka: ");
				double d = Double.parseDouble(vhod.readLine());
				System.out.println(" Vnesi številko obleke: ");
				int n = Integer.parseInt(vhod.readLine());
				System.out.println(" Vnesi številko cevljev: ");
				int in = Integer.parseInt(vhod.readLine());
				Fizicni novDelavec = new Fizicni(n,in,i,mst,dr,d);

				return novDelavec;
	}
	public String shraniKotNiz()
	{
		String vpis = "*F\r\n";
		vpis += this.getIme() + "\r\n";
		vpis += this.getMaticnaSt() + "\r\n";
		vpis += this.getDatumRojstva() + "\r\n";
		vpis += this.getDohodek() + "\r\n";
		vpis += this.stObleke + "\r\n";
		vpis += this.stCevljev + "\r\n";
		vpis += "##\r\n";
		return vpis;
	}
	public static Fizicni preberiIzNiza(ArrayList<String> zapis)
	{
			Fizicni delavec = new Fizicni();
			try
			{
				delavec.setIme(zapis.get(0));
				delavec.setMaticnaSt(Integer.parseInt(zapis.get(1)));
				delavec.setDatumRojstva(zapis.get(2));
				delavec.setDohodek(Double.parseDouble(zapis.get(3)));
				delavec.setStObleke(Integer.parseInt(zapis.get(4)));
				delavec.setStCevljev(Integer.parseInt(zapis.get(5)));
				return delavec;
			}
			catch(Exception ex)
			{
				System.out.println("Napaka v zapisu!");
				throw ex;
			}
	}



}