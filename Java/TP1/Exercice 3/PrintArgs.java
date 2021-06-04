
public class PrintArgs {
	public static void main(String[] args) {
		for(int i = 0; i < args.length;i++) {
			System.out.println(args[i]);
		}
		
		for (var variable : args) {
			System.out.println(variable);
		}
	}

}

//Si on ne passe pas d'argument, le programme se lance mais n'affiche rien'