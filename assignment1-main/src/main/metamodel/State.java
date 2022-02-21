package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {

	private String name;
	private List<Transition> transitionList = new ArrayList<Transition>();
	private Map<String,Integer> varMap = new HashMap<>();
	private String varName = "";
		
	public State(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public List<Transition> getTransitions() {
		return this.transitionList;
	}
	
	public void addTransitions(Transition t) {
		this.transitionList.add(t);
	}
	
	public Transition getTransitionByEvent(String event) {
		Transition temp = null;
		for (Transition trans : transitionList) 
		{
			if(trans.getEvent() == event)
				temp = trans;
		}
		return temp;
	}
	
	public int getNumb(String var) {
		return varMap.get(var);
	}
	
	public void setVar(String var, int i) {
		varMap.put(var, i);
		this.varName = var;
	}
	
	public String getVarName() {
		return this.varName;
	}
}
