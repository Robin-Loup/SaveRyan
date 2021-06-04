package fr.umlv.fight;

public class Robot {
	private String name;
	private int pv;
	
	public Robot(String str) {
		this.name = str;
		pv = 10;
	}
	
	public Robot fire(Robot rob) {
		if (rob.pv == 0) {
			throw new IllegalArgumentException(rob.name + "est mort, on tire pas sur le corbillar");
		}
		if(rollDice()) {
			rob.pv -= 2;
		}
		if (rob.pv < 0)
			rob.pv = 0;
		return rob;
	}
	
	String type() {
		return "Robot";
	}
	
	public Boolean isDead() {
		return (pv <= 0);
	}
	
	boolean rollDice() {
		return true;
	}
	
	@Override
	public String toString() {
		return type() + " " + name;
	}
	public static void main(String[] args) {
		var bob = new Robot("bob");
		var rob = new Robot("rob");
		System.out.println(rob);  // affiche "Robot bob"
		rob = bob.fire(rob);
		rob = bob.fire(rob);
		rob = bob.fire(rob);
		rob = bob.fire(rob);
		rob = bob.fire(rob);
		System.out.println(rob.isDead());  // affiche "Robot bob"
	    
	}

}

/*Exercice 1)
 * 1) Un record construit un constructeur de maniére automatique,
 *  comme il est nécessaire de faire un constructeur différents de
 *  celui de base, mieux vaut faire une classe
 * 
 *Exercice 2)
 * 1) Un genérateur pseudo-aléatoire cree une suite fini a
 *  partir d'un nombre de départ donné, suite qui sera toujours
 *   la même à chaque lancement. Le seed sert a determiner ce nombre de départ.
 * 
 * 3) La visibilité d'un champ ne doit pas être differente que
 *  private ou package pour empecher la modification de ce champ
 *  en dehors de la classe et des classe qui hérite 
 *  
 * 5) Copier coller c'est mal et on risque de faire des erreurs en
 *  cas de modification, mieux vaut faire un code qui s'applique aux
 *  deux classes que deux code identique
 *  
 * 9) le sous typage: un objet qui herite d'une autre classe est aussi considére
 *  comme un objet de cette classe. (ex la methode fight dans Arena qui prend deux
 *  robots en parametres mais accepte un objet Fighter en argument)
 *  
 *  polymorphisme : reecriture de methode, champs...
 *  le compiler regarde le type de l'objet et chisit la methode la plus appropriée (ex: les Override dans Fighter)
 *  
 * 
 */
