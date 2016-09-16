package elements.enumeration;

import elements.Aventurier;
import elements.Carte;
import elements.Case;
import elements.Montagne;
import exception.OutOfLimitsException;

public enum Action {
	AVANCE {
		@Override
		public void perform(Aventurier a) {
			a.getOrientation().avance(a);
		}

		@Override
		public boolean check(Aventurier a, Carte c) {
			Aventurier aFutur = Aventurier.newInstance(a);
			aFutur.getOrientation().avance(aFutur);
			try {
				Case caseCarte = c.getCase(aFutur.getPosition());
				if(caseCarte == null){
					return true;
				}
				if(caseCarte instanceof Montagne){
					return false;
				}
			} catch (OutOfLimitsException e) {
				return false;
			}
			return true;
		}
	},
	DROITE {
		@Override
		public void perform(Aventurier a) {
			a.getOrientation().droite(a);
		}

		@Override
		public boolean check(Aventurier a, Carte c) {
			return true;
		}
	},
	GAUCHE {
		@Override
		public void perform(Aventurier a) {
			a.getOrientation().gauche(a);
		}

		@Override
		public boolean check(Aventurier a, Carte c) {
			return true;			
		}
	},
	ATTENDRE {
		@Override
		public void perform(Aventurier a) {
			
		}

		@Override
		public boolean check(Aventurier a, Carte c) {
			return true;
		}

	};
	
	public abstract void perform(Aventurier a);
	//public abstract void perform(Aventurier a, Carte c);
	public abstract boolean check(Aventurier a,Carte c);
}
