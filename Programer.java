import java.io.*;
import java.util.*;

public class Programer extends Pisarniski
{
	public String znanjeJezika;

	public Programer()
	{
		this.znanjeJezika = "";
	}
	public Programer (String jz)
	{
		this.znanjeJezika = jz;
	}
	public Programer (String jz,int n, int in, String i, int mst, String dr, double d)
	{
		super(n,in,i, mst, dr, d);
		this.znanjeJezika = jz;

	}

	public String getZnanjeJezika()
	{
		return this.znanjeJezika;
	}
	public void setZnanjeJezika(String jz)
	{
		this.znanjeJezika = jz;
	}

	public String toString()
	{
		String opis="";
		opis += super.toString();

		opis+= "Zna jezike: " + this.znanjeJezika + ".\n";

		return opis;
	}

	public static Programer vnesiDelavca() throws Exception
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
		System.out.println(" Vnesi številka nadstropja: ");
		int n = Integer.parseInt(vhod.readLine());
		System.out.println(" Vnesi številko indetitete: ");
		int in = Integer.parseInt(vhod.readLine());
		System.out.println(" Vnesi katere programske jezike zna: ");
		String jz = vhod.readLine();
		Programer novDelavec = new Programer(jz,n,in,i,mst,dr,d);

		return novDelavec;
	}
	public String shraniKotNiz()
	{
		String vpis = "*R\r\n";
		vpis += this.getIme() + "\r\n";
		vpis += this.getMaticnaSt() + "\r\n";
		vpis += this.getDatumRojstva() + "\r\n";
		vpis += this.getDohodek() + "\r\n";
		vpis += this.getStNadst() + "\r\n";
		vpis += this.getStIndet() + "\r\n";
		vpis += this.znanjeJezika + "\r\n";
		vpis += "##\r\n";
		return vpis;
	}
	public static Programer preberiIzNiza(ArrayList<String> zapis)
	{
		Programer delavec = new Programer();
		try
		{
			delavec.setIme(zapis.get(0));
			delavec.setMaticnaSt(Integer.parseInt(zapis.get(1)));
			delavec.setDatumRojstva(zapis.get(2));
			delavec.setDohodek(Double.parseDouble(zapis.get(3)));
			delavec.setStNadst(Integer.parseInt(zapis.get(4)));
			delavec.setStIndet(Integer.parseInt(zapis.get(5)));
			delavec.setZnanjeJezika(zapis.get(6));
			return delavec;
		}
		catch(Exception ex)
		{
			System.out.println("Napaka v zapisu!");
			throw ex;
		}
	}

}