package com.toc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFA {
	private Set<String> states = new HashSet<String>();
	private Set<String> alphabets = new HashSet<String>();
	private String initial_state;
	private Set<String> final_states = new HashSet<String>();
	private Map<StateFuct, String> transitionMap = new HashMap<StateFuct, String>();

	public Set<String> getStates() {
		return states;
	}

	public void setStates(Set<String> states) {
		this.states = states;
	}

	public Set<String> getAlphabets() {
		return alphabets;
	}

	public void setAlphabets(Set<String> alphabets) {
		this.alphabets = alphabets;
	}

	public String getInitial_state() {
		return initial_state;
	}

	public void setInitial_state(String initial_state) {
		this.initial_state = initial_state;
	}

	public Set<String> getFinal_states() {
		return final_states;
	}

	public void setFinal_states(Set<String> final_states) {
		this.final_states = final_states;
	}

	public Map<StateFuct, String> getTransitionMap() {
		return transitionMap;
	}

	public void setTransitionMap(Map<StateFuct, String> transitionMap) {
		this.transitionMap = transitionMap;
	}

	@Override
	public String toString() {
		return "\n Q-Set of States        : {" + states + "} \n Set of alphabets       : {"
				+ alphabets + "} \n initial_state          : " + initial_state
				+ " \n F-Set of Final States  : {" + final_states + "} \n Delta-Transitions      : {"
				+ transitionMap + "}";
	}
}
