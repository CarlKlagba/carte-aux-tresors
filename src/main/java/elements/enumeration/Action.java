package elements.enumeration;

import elements.Aventurier;

public enum Action {
	AVANCE {
		@Override
		public void perform(Aventurier a) {
			a.getOrientation().avance(a);
		}
	},
	DROITE {
		@Override
		public void perform(Aventurier a) {
			a.getOrientation().droite(a);
		}
	},
	GAUCHE {
		@Override
		public void perform(Aventurier a) {
			a.getOrientation().gauche(a);
		}
	},
	ATTENDRE {
		@Override
		public void perform(Aventurier a) {
			
		}
	},
	RAMASSE {
		@Override
		public void perform(Aventurier a) {
			
		}
	};
	
	public abstract void perform(Aventurier a);
}
