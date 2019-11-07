package no.hvl.dat100.jplab12.oppgave4;

import java.io.BufferedWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.Innlegg;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) {
		boolean skrevet = false;
		System.out.println(skrevet);
		
		
		//PrintWriter skriver = null;
		Innlegg[] sm = samling.getSamling();
		int an = samling.getAntall();
		Innlegg a = null;
		Innlegg b = null;
		
		try {
			
		PrintWriter fw = new PrintWriter(MAPPE + filnavn);
		
		for (int i = 0; i < sm.length; i++) {
			a = sm[i];
			b = sm[i+1];
		
		fw.print(an + "\n" + a.toString()+b.toString());
			if(fw != null) {
				skrevet = true;
		
				fw.close();
		}
		}
		//throw new UnsupportedOperationException(TODO.method());
		}catch (Exception e) {
			System.out.println("Feil?: " + e.getClass());

		}
		return skrevet;
		 
	}
}