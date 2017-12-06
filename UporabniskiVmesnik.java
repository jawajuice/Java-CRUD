import java.io.*;
import java.util.*;

public class UporabniskiVmesnik
{
	public static void main(String[] args)
	{
		System.out.println("\n*** Dobrodošli v program podjetja! ***\n");

		SeznamDelavcev seznam = new SeznamDelavcev();

		while (true)
		{
			BufferedReader vhod = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Pritisnite (i) za vnos delavca");
			System.out.println("Pritisnite (p) za izpis");
			System.out.println("Pritisnite (d) za brisanje delavca");
			System.out.println("Pritisnite (s) za shranjevanje v datoteko");
			System.out.println("Pritisnite (v) za vpis iz datoteke");
			System.out.println("Pritisnite (x) za izhod");
			String niz;

			try
			{
				niz = vhod.readLine();
				char izbira = niz.charAt(0);

				switch (izbira)
				{
					case 'i':
						// Izberemo, kateri tip avta želimo vnesti. a za splošen avto, l za limuzino
						System.out.println("Izberite kakšen tip delavca želite dodati (d - Delavec, f - Fizični delavec, o - Operater, c - Čistilka, p - Pisarniški delavec, k - Direktor, r - Programer): ");
						izbira = vhod.readLine().toLowerCase().charAt(0);

						Delavec novDelavec = null;
						String obvestilo = "";
						switch(izbira)
						{
							case 'f':
								novDelavec = Fizicni.vnesiDelavca();
								break;
							case 'o':
								novDelavec = Operater.vnesiDelavca();
								break;
							case 'c':
								novDelavec = Cistilka.vnesiDelavca();
								break;
							case 'p':
								novDelavec = Pisarniski.vnesiDelavca();
								break;
							case 'k':
								novDelavec = Direktor.vnesiDelavca();
								break;
							case 'r':
								novDelavec = Programer.vnesiDelavca();
								break;

							case 'd':
							default:
								novDelavec = Delavec.vnesiDelavca();
								break;
						}
						obvestilo = seznam.dodajDelavca(novDelavec);
						if(obvestilo.length() > 0)
							System.out.println(obvestilo);
						else
							System.out.println(novDelavec.toString());
						break;
					case 'x':
						System.out.println("Program zakljucen!");
						return;
					case 'd':
						System.out.println("Vnesite matično številko delavca, ki ga želite odpustiti.");
						int mat = Integer.parseInt(vhod.readLine());
						boolean odpusti = seznam.odpustiDelavca(mat);
						if(odpusti==true)
							System.out.println("Delavec je bil uspešno odpuščen.");
						else
							System.out.println("Tak delavec ne obstaja.");
						break;
					case 'p':
						System.out.println("Izberite kakšen tip izpisa želite (n - navadni izpis vseh delavcev, v - izpis vseh z placo manjs od 1000 EUR, d - izpis vseh mladoletnih zaposlenih, i - izpis vseh z imenom na T: ");
						izbira = vhod.readLine().toLowerCase().charAt(0);
						switch(izbira)
						{
							case 'v':
								System.out.println(seznam.izpisMinimalnihDohodkov());
								break;
							case 'd':
								System.out.println(seznam.izpisStarostiDelavcev());
								break;
							case 'i':
								System.out.println(seznam.izpisImenNaT());
								break;
							case 'n':
							default:
								System.out.println(seznam.toString());
								break;
						}
						break;
					case 's':
						System.out.println("Vnesite ime datoteke za shranjevanje!");
						String datShrani = vhod.readLine();
						seznam.shraniVDatoteko(datShrani);
						System.out.println("Seznam delavcev je uspešno shranjen.");
						break;
					case 'v':
						System.out.println("Vnesite ime datoteke za branje!");
						String datBeri = vhod.readLine();
						seznam.dodajIzDatoteke(datBeri);
						System.out.println("Delavci so uspešno dodani!");
						break;
					default:
						break;
				}
			}
			catch (Exception e)
			{
				System.out.println("Napaka - poskusite znova!");
			}
		}
	}
}