package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	// TODO: objektvariable 
	private Innlegg[] tabell;
	protected int nesteledige = 0;

	public Blogg() {
		this.tabell = new Innlegg[20];
		this.nesteledige = 0;
		//throw new UnsupportedOperationException(TODO.constructor("Blogg"));
	}

	public Blogg(int lengde) {
		this.tabell = new Innlegg[lengde];
		nesteledige = 0;
		//throw new UnsupportedOperationException(TODO.constructor("Blogg"));
	}

	public int getAntall() {
		int counter = 0;
		for (int i = 0; i < tabell.length; i++) {
			if(tabell[i] != null) {
				counter++;
			}
		}
		//throw new UnsupportedOperationException(TODO.method());
		return counter;
	}
	
	public Innlegg[] getSamling() {
		return this.tabell;
		//throw new UnsupportedOperationException(TODO.method());

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		
		int a = -1;
		int pos = 0;
		while (pos < nesteledige && a == -1) {
			if(tabell[pos].erLik(innlegg)) {
				a = pos;
			}
			pos++;
		}		
		return a;
		

		//throw new UnsupportedOperationException(TODO.method());
	}

	public boolean finnes(Innlegg innlegg) {
		boolean funnet = false;
		
		for(int z = 0; z < tabell.length; z++) {
			if(tabell[z] != null) {
				if(tabell[z].erLik(innlegg)) {
					funnet = true;
				}
			}
		}
		
			
		return funnet;
		//throw new UnsupportedOperationException(TODO.method());
	}

	public boolean ledigPlass() {
		boolean ledig = false;
		for(int i = 0; i < tabell.length; i++) {
			if(tabell[i] == null && i < tabell.length ) {
				ledig = true;
				
			
			}
		}
		return ledig;
		//throw new UnsupportedOperationException(TODO.method());

	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean sattinn = false;
		//System.out.println(innlegg.getBruker());
		if(ledigPlass() && !finnes(innlegg)) {
			tabell[nesteledige] = innlegg;
			nesteledige++;
			sattinn = true;
		}else {
			return false;
		}
		return sattinn;
		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public String toString() {
		Innlegg t = null;
		Innlegg a = null;
		for(int i = 0; i < tabell.length-1; i++) {
			t = tabell[i+1];
			a = tabell[i];
		}
		return getAntall() +"\n"+ a.toString() + t.toString();
				
		//throw new UnsupportedOperationException(TODO.method());
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] ny = new Innlegg[2*tabell.length];
		for(int i = 0; i < nesteledige; i++) {
			ny[i] = tabell[i];
		}
		tabell = ny;
		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagttil = false;
		
		if(!finnes(innlegg) && ledigPlass()) {
			leggTil(innlegg);
			lagttil = true;
		}else if(finnes(innlegg)) {
			return lagttil;
			
		} else if(!finnes(innlegg) && !ledigPlass()) {
			utvid();
			leggTil(innlegg);
			lagttil = true;
		}
		return lagttil;
		//throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public void slett(Innlegg innlegg) {
		int p = finnInnlegg(innlegg);
		boolean slettet = false;
		if (p>=0) {
			nesteledige--;
			tabell[p] = tabell[nesteledige];
			tabell[nesteledige] = null;
			slettet = true;
		}else {
			slettet = false;
		}
		
		//throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		//feil, fann ikkje ut riktig metode
		int[] id1 = new int[tabell.length];
		for(int i = 0; i < tabell.length; i++) {
			if(keyword.equals(i)){
				System.out.println(tabell[i]);
				
			}
		
		}
		return id1;
		//throw new UnsupportedOperationException(TODO.method());

	}
}