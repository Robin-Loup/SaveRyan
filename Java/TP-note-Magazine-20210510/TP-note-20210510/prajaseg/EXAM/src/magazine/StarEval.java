package magazine;

public class StarEval implements Eval{
	private int i;
	private String string;

	public StarEval(int i, String string) {
		this.i=i;
		this.string=string;
	}

	@Override
	public int score() {
		return 20*i-50;
	}
	
	@Override
	public String toString() {
		return "*".toString().repeat(i)+" "+this.string;
	}

}
