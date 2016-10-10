package com.toc;

import java.util.Map;

public class DFAOperation {

	public static DFA union(DFA dfa1, DFA dfa2) {
		// Populating states
		DFA result = new DFA();
		for (String state1 : dfa1.getStates()) {
			for (String state2 : dfa2.getStates()) {
				result.getStates().add(state1 + state2);
			}
		}

		// Populating alphabets
		result.setAlphabets(dfa1.getAlphabets());

		// Populating initial state
		result.setInitial_state(dfa1.getInitial_state()
				+ dfa2.getInitial_state());

		// Populating final state
		for (String fstate1 : dfa1.getFinal_states()) {
			for (String state : result.getStates()) {
				if (state.contains(fstate1)) {
					result.getFinal_states().add(state);
				}
			}
		}

		for (String fstate2 : dfa2.getFinal_states()) {
			for (String state : result.getStates()) {
				if (state.contains(fstate2)) {
					result.getFinal_states().add(state);
				}
			}
		}

		// Populating transitions
		Map<StateFuct, String> transitionMap1 = dfa1.getTransitionMap();
		Map<StateFuct, String> transitionMap2 = dfa2.getTransitionMap();

		for (String resultState : result.getStates()) {
			// On input alphabet 'a'
			String firstMachineState = resultState.substring(0, 2);
			String secondMachineState = resultState.substring(2);

			// transition on a first m/c

			String resultantState1a = transitionMap1.get(new StateFuct(
					firstMachineState, "a"));

			String resultantState2a = transitionMap2.get(new StateFuct(
					secondMachineState, "a"));

			result.getTransitionMap().put(new StateFuct(resultState, "a"),
					resultantState1a + resultantState2a);

			// On input alphabet 'b'

			String resultantState1b = transitionMap1.get(new StateFuct(
					firstMachineState, "b"));
			String resultantState2b = transitionMap2.get(new StateFuct(
					secondMachineState, "b"));
			result.getTransitionMap().put(new StateFuct(resultState, "b"),
					resultantState1b + resultantState2b);

		}
		return result;
	}

	public static DFA intersection(DFA dfa1, DFA dfa2) {
		// Populating states
		DFA result = new DFA();
		for (String state1 : dfa1.getStates()) {
			for (String state2 : dfa2.getStates()) {
				result.getStates().add(state1 + state2);
			}
		}

		// Populating alphabets
		result.setAlphabets(dfa1.getAlphabets());

		// Populating initial state
		result.setInitial_state(dfa1.getInitial_state()
				+ dfa2.getInitial_state());

		// Populating final state
		for (String fstate1 : dfa1.getFinal_states()) {
			for (String fstate2 : dfa2.getFinal_states()) {
				result.getFinal_states().add(fstate1+fstate2);
			}
		}

		// Populating transitions
		Map<StateFuct, String> transitionMap1 = dfa1.getTransitionMap();
		Map<StateFuct, String> transitionMap2 = dfa2.getTransitionMap();

		for (String resultState : result.getStates()) {
			// On input alphabet 'a'
			String firstMachineState = resultState.substring(0, 2);
			String secondMachineState = resultState.substring(2);

			// transition on a first m/c

			String resultantState1a = transitionMap1.get(new StateFuct(
					firstMachineState, "a"));

			String resultantState2a = transitionMap2.get(new StateFuct(
					secondMachineState, "a"));

			result.getTransitionMap().put(new StateFuct(resultState, "a"),
					resultantState1a + resultantState2a);

			// On input alphabet 'b'

			String resultantState1b = transitionMap1.get(new StateFuct(
					firstMachineState, "b"));
			String resultantState2b = transitionMap2.get(new StateFuct(
					secondMachineState, "b"));
			result.getTransitionMap().put(new StateFuct(resultState, "b"),
					resultantState1b + resultantState2b);

		}

		return result;
	}
	
	public static DFA complement(DFA dfa1){
		DFA result = new DFA();
		result.getStates().addAll(dfa1.getStates());
		result.getAlphabets().addAll(dfa1.getAlphabets());
		result.setInitial_state(dfa1.getInitial_state());
		result.getTransitionMap().putAll(dfa1.getTransitionMap());
		for (String state1 : dfa1.getStates()) {
			if(!dfa1.getFinal_states().contains(state1)){
				result.getFinal_states().add(state1);
			}
		}
		return result;
	}

}
