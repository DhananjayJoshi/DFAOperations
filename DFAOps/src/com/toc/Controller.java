package com.toc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Controller {

	public static void main(String[] args) {
		DFA dfa1 = null;
		dfa1 = populateDfa("1");
		System.out.println("L1: " + dfa1);
		System.out.println("\n-----------------------------------------------------\n");

		DFA dfa2 = null;
		dfa2 = populateDfa("2");
		System.out.println("L2: " + dfa2);
		System.out.println("\n-----------------------------------------------------\n");
		
		DFA dfa3 = null;
		dfa3 = populateDfa("3");
		System.out.println("L3: " + dfa3);
		System.out.println("\n-----------------------------------------------------\n");

		
		DFA intersected = DFAOperation.intersection(dfa1, dfa2);
		System.out.println("(a) L1 INTERECTION L2 : " + intersected);
		System.out.println("\n-----------------------------------------------------\n");
		
		DFA unioned = DFAOperation.union(dfa1, dfa3);
		System.out.println("(b) L1 UNION L3 : " + unioned);
		System.out.println("\n-----------------------------------------------------\n");
		
		DFA compinterected = DFAOperation.intersection(dfa1, DFAOperation.complement(dfa3));
		System.out.println("(c) L1 INTERSECTION L3-Complement : " + compinterected);
		System.out.println("\n-----------------------------------------------------\n");
		
		DFA compunioned = DFAOperation.union(dfa3, DFAOperation.complement(dfa3));
		System.out.println("(d) L3 UNION L3-Complement : " + compunioned);
		System.out.println("\n-----------------------------------------------------\n");

	


	}

	public static DFA populateDfa(String suffix) {
		DFA dfa = new DFA();
		InputStream input = null;
		try {
			input = new FileInputStream("src/input.property");
			Properties prop = new Properties();
			prop.load(input);

			String[] states = prop.getProperty("states_" + suffix).split(",");
			for (String string : states) {
				dfa.getStates().add(string);
			}

			states = prop.getProperty("alphabet_" + suffix).split(",");
			for (String string : states) {
				dfa.getAlphabets().add(string);
			}

			states = prop.getProperty("finalstates_" + suffix).split(",");
			for (String string : states) {
				dfa.getFinal_states().add(string);
			}

			dfa.setInitial_state(prop.getProperty("initialstate_" + suffix));

			String[] transitions = prop.getProperty("transition_" + suffix)
					.split(";");
			for (String transition : transitions) {
				states = transition.split(",");
				String alphabets[] = states[1].split("-");
				StateFuct statefunct = new StateFuct(states[0], alphabets[0]);
				dfa.getTransitionMap().put(statefunct, alphabets[1]);
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dfa;

	}

}
