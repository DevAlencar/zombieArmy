package combate;

import controle.ControleColisao;
import entidades.Boss;
import entidades.Player;
import jplay.Sprite;
import jplay.URL;

public class Projetil extends Sprite {

	public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;

	protected static final int VELOCIDADE_TIRO = 2;

	protected int caminho = STOP;
	protected boolean movendo = false;
	protected int direcao = 3;

	public Projetil(double x, double y, int caminho) {
		super(URL.sprite("tiro.png"), 16);
		this.caminho = caminho;
		this.x = x + 10;
		this.y = y + 8;
	}

	public void mover() {
		if (caminho == LEFT) {
			this.x -= VELOCIDADE_TIRO;
			if (direcao != 1) {
				setSequence(4, 8);
			}
			movendo = true;
		}

		if (caminho == RIGHT) {
			this.x += VELOCIDADE_TIRO;
			if (direcao != 2) {
				setSequence(8, 12);
			}
			movendo = true;
		}

		if (caminho == UP) {
			this.y -= VELOCIDADE_TIRO;
			if (direcao != 4) {
				setSequence(12, 16);
			}
			movendo = true;
		}

		if (caminho == DOWN || caminho == STOP) {
			this.y += VELOCIDADE_TIRO;
			if (direcao != 5) {
				setSequence(0, 4);
			}
			movendo = true;
		}

		if (movendo) {
			update();
			movendo = false;
		}
	}
	
	public void estatico(Player player) {
		if(player.getMovendo()) {
			if(player.x > 510 && player.x < 514 && ControleColisao.colisao(player, player.getTile()) == false) {
				if(player.getDirecao() == 1) {
					this.x += player.getVelocidade();
				} 
				if(player.getDirecao() == 2) {
					this.x -= player.getVelocidade();
				}
			}
			if(player.y > 382 && player.y < 386 && ControleColisao.colisao(player, player.getTile()) == false) {
				if(player.getDirecao() == 4) {
					this.y += player.getVelocidade();
				} 
				if(player.getDirecao() == 5) {
					this.y -= player.getVelocidade();
				}
			}
		}
	}
	
	public void estatico(Boss player) {
		if(player.getMovendo()) {
			if(player.x > 510 && player.x < 514 && ControleColisao.colisao(player, player.getTile()) == false) {
				if(player.getDirecao() == 1) {
					this.x += player.getVelocidade();
				} 
				if(player.getDirecao() == 2) {
					this.x -= player.getVelocidade();
				}
			}
			if(player.y > 382 && player.y < 386 && ControleColisao.colisao(player, player.getTile()) == false) {
				if(player.getDirecao() == 4) {
					this.y += player.getVelocidade();
				} 
				if(player.getDirecao() == 5) {
					this.y -= player.getVelocidade();
				}
			}
		}
	}
}
