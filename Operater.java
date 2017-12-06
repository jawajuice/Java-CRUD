import java.io.*;
import java.util.*;

public class Operater extends Fizicni
{
	public int stTelefona;

	public Operater()
	{
		this.stTelefona = 0;
	}
	public Operater(int t)
	{
		this.stTelefona = t;
	}
	public Operater(int t, int n, int in, String i, int mst, String dr, double d)
	{
		super(n,in,i,mst,dr,d);
		this.stTelefona = t;

	}

	public int getStTelefona()
	{
		return this.stTelefona;
	}
	public void setStTelefona(int t)
	{
		this.stTelefona = t;
	}

	public String toString()
		{
			String opis="";
			opis += super.toString();

			opis+= "Številke telefona: " + this.stTelefona + ".\n";

			return opis;
		}

	public static Operater vnesiDelavca() throws Exception
	{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("***   Vnos novega delavca operaterja na traku:   ***");
			System.out.println(" Vnesite Ime in priimek delavca: ");
			String i = vhod.readLine();
			System.out.println(" Vnesite matično številko delavca: ");
			int mst = Integer.parseInt(vhod.readLine());
			System.out.println(" Vnesite datum rojstva delavca: ");
			String dr = vhod.readLine();
			System.out.println(" Vnesi višino dohodek: ");
			double d = Double.parseDouble(vhod.readLine());
			System.out.println(" Vnesi številko obleke: ");
			int n = Integer.parseInt(vhod.readLine());
			System.out.println(" Vnesi številko cevljev: ");
			int in = Integer.parseInt(vhod.readLine());
			System.out.println(" Vnesi številko telefona: ");
			int t = Integer.parseInt(vhod.readLine());
			Operater novDelavec = new Operater(t,n,in,i,mst,dr,d);

			return novDelavec;
	}
	public String shraniKotNiz()
		{
			String vpis = "*O\r\n";
			vpis += this.getIme() + "\r\n";
			vpis += this.getMaticnaSt() + "\r\n";
			vpis += this.getDatumRojstva() + "\r\n";
			vpis += this.getDohodek() + "\r\n";
			vpis += this.getStObleke() + "\r\n";
			vpis += this.getStCevljev() + "\r\n";
			vpis += this.stTelefona + "\r\n";
			vpis += "##\r\n";
			return vpis;
		}
	public static Operater preberiIzNiza(ArrayList<String> zapis)
	{
			Operater delavec = new Operater();
			try
			{
				delavec.setIme(zapis.get(0));
				delavec.setMaticnaSt(Integer.parseInt(zapis.get(1)));
				delavec.setDatumRojstva(zapis.get(2));
				delavec.setDohodek(Double.parseDouble(zapis.get(3)));
				delavec.setStObleke(Integer.parseInt(zapis.get(4)));
				delavec.setStCevljev(Integer.parseInt(zapis.get(5)));
				delavec.setStTelefona(Integer.parseInt(zapis.get(6)));
				return delavec;
			}
			catch(Exception ex)
			{
				System.out.println("Napaka v zapisu!");
				throw ex;
			}
	}
}