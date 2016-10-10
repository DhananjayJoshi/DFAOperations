package com.toc;

import java.util.Objects;

public final class  StateFuct {
	
	private final String state;
	private final String alphabet;

	public String getState() {
		return state;
	}

	public String getAlphabet() {
		return alphabet;
	}

	public StateFuct(String state, String alphabet) {
		super();
		this.state = state;
		this.alphabet = alphabet;
	}

	@Override
	public String toString() {
		return "("+ state + "," + alphabet + ")";
	}

	@Override
	public int hashCode() {
	    return Objects.hash(this.alphabet, this.state);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || getClass() != obj.getClass())
	        return false;
	    StateFuct other = (StateFuct) obj;
	    return (Objects.equals(this.alphabet, other.alphabet) &&
	            Objects.equals(this.state, other.state));
	}
}
