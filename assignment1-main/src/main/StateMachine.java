package main;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {


	private Machine machine = new Machine();
	private State currentState = null;
	private String currentEvent = null;
	private Transition currentTransition = null;
	
	private Map<String,State> stateMap = new HashMap<>();
	private Map<String,Integer> varMap = new HashMap<>();
	
	public Machine build() {
		return this.machine;
	}

	
	//Add state to the machine
	public StateMachine state(String name) {
		machine.setState(name);
		this.currentState = machine.getState(name);
		return this;
	} 
	
	//Maybe make list
	public State getState(String name) {
		if(!stateMap.containsKey(name)) stateMap.put(name, new State(name));
		return stateMap.get(name);
	}

	//Set the called state initial
	public StateMachine initial() {
		machine.setInitialState(this.currentState);
		return this;
	}

	
	public StateMachine when(String event) {
		currentEvent = event;
		return this;
	}

	public StateMachine to(String state) {
		Transition t = new Transition(currentEvent,getState(state));
		this.currentState.addTransitions(t);
		this.currentTransition = t;
		return this;
	}

	public StateMachine integer(String var) {
		machine.addIntegers(var);
		return this;
	}
	

	public StateMachine set(String var, int i) {
		machine.addValue(var,i);
		varMap.put(machine.getInteger(var),i);
		this.currentState.setVar(var, i);
		this.currentTransition.setOp("SET",var);
		return this;
	}

	public StateMachine increment(String var) {
		int current = this.machine.getFromMap(var);
		this.machine.addValue(var, current +1);
		this.currentTransition.setOp("INCREMENT",var);
		return this;
	}

	public StateMachine decrement(String var) {
		int current = this.machine.getFromMap(var);
		this.machine.addValue(var, current -1);
		this.currentTransition.setOp("DECREMENT",var);
		return this;
	}

	public StateMachine ifEquals(String var, int i) {
		if(machine.getInteger(var) != null) {
			this.varMap.put(var, i);
		}
		this.currentTransition.setCon("EQUALS",i,var);
		return this;
	}

	public StateMachine ifGreaterThan(String var, int i) {
		if(machine.getInteger(var) != null) {
			this.varMap.put(var, i);
		}
			this.currentTransition.setCon("GREATER",i,var);
		return this;
	}

	public StateMachine ifLessThan(String var, int i) {
		if(machine.getInteger(var) != null) {
			this.varMap.put(var, i);
		}
		this.currentTransition.setCon("LESS",i,var);
		return this;
	}

}
