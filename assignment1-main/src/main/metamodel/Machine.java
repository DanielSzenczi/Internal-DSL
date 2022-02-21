package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {

	private List<State> stateList = new ArrayList<State>();
	private List<String> varList = new ArrayList<String>();
	private Map<String,Integer> testMap = new HashMap<>();
	private State initState;



	public List<State> getStates() {
		return this.stateList;
	}
	
	
	//Add a state to the machine
	public void setState(String StateName) {
		State s = new State(StateName);
		stateList.add(s);
	}

	public State getInitialState() {
		return this.initState;
	}

	public void setInitialState(State s) {
		this.initState = s;
	}
	public State getState(String string) {
		for (State state : stateList) 
		{
		   if(state.getName() == string) return state;
		}
		return null;
	}


	public int numberOfIntegers() {
		return varList.size();
	}
	
	public void addIntegers(String var) {
		this.varList.add(var);
		if(!testMap.containsKey(var)) {
			this.testMap.put(var,0);
		}
	}
	
	public void addValue(String var, int i ) {
		if(testMap.containsKey(var)) {
			this.testMap.put(var,i);
		}
		this.testMap.put(var, i);
	}
	
	
	public int getFromMap(String var) {
		return testMap.get(var);
	}
	
	public String getVarName() {
		return this.varList.get(0);
	}
	
	public String getInteger(String target) {
		String temp = null;
		for (String var : varList) 
		{
			if(var == target)
				temp = var;
		}
		return temp;
	}
	

	//Check if variable exist;
	public boolean hasInteger(String target) {
		return varList.contains(target);
	}

}
