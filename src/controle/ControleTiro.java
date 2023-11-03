package controle;

import java.util.LinkedList;

import combate.Projetil;
import entidades.Boss;
import entidades.Player;
//import entidades.Entidade;
import entidades.Zumbi;
import jplay.Scene;
import jplay.Sound;
import jplay.URL;

public class ControleTiro {

	LinkedList<Projetil> tiros = new LinkedList<>();
	public Projetil tiro;

	public void adicionaTiro(double x, double y, int caminho, Scene cena) {
		tiro = new Projetil(x, y, caminho);
		tiros.addFirst(tiro);
		cena.addOverlay(tiro);
		somDisparo();
	}

	public void run(Zumbi inimigo, Player player, Scene cena) {
		for (int i = 0; i < tiros.size(); i++) {
			Projetil tiro = tiros.removeFirst();
			tiro.mover();
			tiro.estatico(player);
			tiros.addLast(tiro);
			
			if(tiro.collided(inimigo)) {
				cena.removeOverlay(tiro);
				inimigo.setLife(inimigo.getLife()-player.getAtaque());
			}
		}
	}
	
	public void run(Boss inimigo, Player player, Scene cena) {
		for (int i = 0; i < tiros.size(); i++) {
			Projetil tiro = tiros.removeFirst();
			tiro.mover();
			tiro.estatico(player);
			tiros.addLast(tiro);
			
			if(tiro.collided(inimigo)) {
				cena.removeOverlay(tiro);
				inimigo.setLife(inimigo.getLife()-player.getAtaque());
			}
		}
	}
	
	public void run(Player inimigo, Boss player, Scene cena) {
		for (int i = 0; i < tiros.size(); i++) {
			Projetil tiro = tiros.removeFirst();
			tiro.mover();
			tiro.estatico(inimigo);
			tiros.addLast(tiro);
			
			if(tiro.collided(inimigo)) {
				cena.removeOverlay(tiro);
				inimigo.setLife(inimigo.getLife()-player.getAtaque());
			}
		}
	}

	private void somDisparo() {
		new Sound(URL.audio("tiro.wav")).play();
	}
}
