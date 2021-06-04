package fr.umlv;

public enum AppleKind {
	Golden("Golden"), PinkLady("Pink Lady"), GrannySmith("GrannySmith");
	
	private final String name;
	
	private AppleKind(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
