import java.util.*;
import java.io.*;

public class SeznamDelavcev
{
	private ArrayList<Delavec> delavci;


	public SeznamDelavcev()
	{
		delavci = new ArrayList<Delavec>();
	}

	public SeznamDelavcev (int steviloDel)
	{
		delavci = new ArrayList<Delavec>();

		for(int i=0; i < steviloDel; i++)
		{
			try
			{
				Delavec d = Delavec.vnesiDelavca();	
				this.delavci.add(d);
			}
			catch (Exception e)
			{
				System.out.println("Napaka pri vnosu delavca!");
			}
		}
	}

	public ArrayList<Delavec> getDelavci()
	{
		return this.delavci;
	}

	public String dodajDelavca(Delavec del) // Metodi dodamo vraèanje niza za obvešèanje uporabnika
	{
		boolean obstaja = false;
		for(Delavec d : this.delavci)
		{
			if(d.getMaticnaSt() == del.getMaticnaSt())
			{
				obstaja = true;
				break;
			}
		}

		if(obstaja == false)
			this.delavci.add(del);
		else
			return "Delavec s to matično številko že obstaja.";
		return "";
	}

	public String toString()
	{
		String opis = "";
		if(this.delavci.size() > 0)
		{
			opis += "V podjetju so zaposleni naslednji delavci:\n\n";

			for(int i=0; i < this.delavci.size(); i++)
			{
				opis += this.delavci.get(i).toString() + "\n";
			}
		}
		else
		{
			opis += "Podjetje nima zaposlenih. \n";
		}
		return opis;
	}

	public String izpisMinimalnihDohodkov()
		{
			String opis = "";
			if(this.delavci.size() > 0)
			{
				boolean prvic = false;

				for(Delavec d : this.delavci)
				{
					if(d.getDohodek()< 1000)
					{
						if(prvic == false)
						{
							opis += "V podjetju imajo placo manjso od 1000 EUR naslednji delavci:\n\n";
							opis+= d.toString() + "\n";
							prvic = true;
						}
						else
							opis+= d.toString() + "\n";
					}
				}
				if ( prvic == false)
					opis += "V podjetju nima noben plačo nižjo od 1000 EUR.\n";
			}
			else
			{
				opis += "Podjetje nima zaposlenih. \n";
			}
			return opis;
	}

	public String izpisStarostiDelavcev()
	{
		String opis = "";
		int a = 2016;
		String temp = "";
		if(this.delavci.size() > 0)
		{
			boolean prvic = false;

			for(Delavec d : this.delavci)
			{
				temp = d.getDatumRojstva();
				temp = temp.substring(4);
				a = Integer.parseInt(temp);
				if(a>1998)
				{
					if(prvic == false)
					{
						opis += "V podjetju so mladoletni naslednji delavci:\n";
						opis += d.toString() + "\n";
						prvic = true;
					}
					else
						opis += d.toString() + "\n";
				}
			}
			if (prvic == false)
				opis += "V podjetju ni nobenega mladoletnega";
		}
		else
			opis +="Podjetje nima zaposlenih. \n";
		return opis;
	}
	public String izpisImenNaT()
	{
		String opis = "";
		String temp = "";
		char znak = 'a';
		if ( this.delavci.size() >0)
		{
			boolean prvic = false;
			for(Delavec d : this.delavci)
			{
				temp = d.getIme();
				znak = temp.toLowerCase().charAt(0);
				if (znak == 'l')
				{
					if(prvic == false)
					{
						opis += "V podjetju so naslednji delavci, katerim se ime začne z L: \n";
						opis += d.toString() + "\n";
						prvic = true;
					}
					else
					{
						opis += d.toString() + "\n";
					}

				}
			}
			if (prvic == false)
				opis += "V podjetju ni nobenega zaposlenega kateremu se ime začne z L.";
		}
		else
			opis += " V podjetju ni nobenega zaposlenega.";
		return opis;
	}

	public void shraniVDatoteko(String imeDatoteke) throws IOException
	{
		FileWriter fw = new FileWriter(imeDatoteke, true); // Drugi parameter doloèa, da se že obstojeèi datoteki zapis doda
		PrintWriter dat = new PrintWriter(fw);

		for(Delavec del : this.delavci)
		{
			dat.print(del.shraniKotNiz());
		}

		dat.close();
	}

	public void dodajIzDatoteke(String imeDatoteke) throws Exception
	{
		FileReader fr = new FileReader(imeDatoteke);
		BufferedReader dat = new BufferedReader(fr);

		ArrayList<String> podatkiODelavcu;
		while(dat.ready())
		{
			String vrstica = dat.readLine().trim().toUpperCase();
			if(vrstica.equals("*D"))	
			{
				podatkiODelavcu = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("////"))
				{
					vrstica = dat.readLine().trim();
					podatkiODelavcu.add(vrstica);
				}

				Delavec novDelavec = Delavec.preberiIzNiza(podatkiODelavcu);
				if(!delavecZeObstaja(novDelavec))
					this.delavci.add(novDelavec);
			}
			else if(vrstica.equals("*F"))	
			{
				podatkiODelavcu = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("////"))
				{
					vrstica = dat.readLine().trim();
					podatkiODelavcu.add(vrstica);
				}

				Fizicni novDelavec = Fizicni.preberiIzNiza(podatkiODelavcu);
				if(!delavecZeObstaja(novDelavec))
					this.delavci.add(novDelavec);
			}
			else if(vrstica.equals("*P"))
			{
				podatkiODelavcu = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("////"))
				{
					vrstica = dat.readLine().trim();
					podatkiODelavcu.add(vrstica);
				}

				Pisarniski novDelavec = Pisarniski.preberiIzNiza(podatkiODelavcu);
				if(!delavecZeObstaja(novDelavec))
					this.delavci.add(novDelavec);
			}
			else if(vrstica.equals("*O"))
			{
				podatkiODelavcu = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("////"))
				{
					vrstica = dat.readLine().trim();
					podatkiODelavcu.add(vrstica);
				}

				Operater novDelavec = Operater.preberiIzNiza(podatkiODelavcu);
				if(!delavecZeObstaja(novDelavec))
					this.delavci.add(novDelavec);
			}
			else if(vrstica.equals("*C"))
			{
				podatkiODelavcu = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("////"))
				{
					vrstica = dat.readLine().trim();
					podatkiODelavcu.add(vrstica);
				}

				Cistilka novDelavec = Cistilka.preberiIzNiza(podatkiODelavcu);
				if(!delavecZeObstaja(novDelavec))
					this.delavci.add(novDelavec);
			}
			else if(vrstica.equals("*K"))
			{
				podatkiODelavcu = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("////"))
				{
					vrstica = dat.readLine().trim();
					podatkiODelavcu.add(vrstica);
				}

				Direktor novDelavec = Direktor.preberiIzNiza(podatkiODelavcu);
				if(!delavecZeObstaja(novDelavec))
					this.delavci.add(novDelavec);
			}
			else if(vrstica.equals("*R"))
			{
				podatkiODelavcu = new ArrayList<String>();
				while(dat.ready() && !vrstica.equals("////"))
				{
					vrstica = dat.readLine().trim();
					podatkiODelavcu.add(vrstica);
				}
				Programer novDelavec = Programer.preberiIzNiza(podatkiODelavcu);
				if(!delavecZeObstaja(novDelavec))
					this.delavci.add(novDelavec);
			}
		}
		dat.close();
	}

	private boolean delavecZeObstaja(Delavec delavec)
	{
		boolean obstaja = false;
		for(Delavec d : this.delavci)
		{
			if(d.getMaticnaSt() == delavec.getMaticnaSt())
			{
				obstaja = true;
				break;
			}
		}
		return obstaja;
	}
	public boolean odpustiDelavca(int mat)
	{
		int stevec = 0;
		for(Delavec d : this.delavci)
		{
			if(d.getMaticnaSt() == mat)
			{
				delavci.remove(stevec);
				return true;
			}
			stevec++;
		}
		return false;
	}
}