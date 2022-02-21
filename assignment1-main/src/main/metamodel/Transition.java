package main.metamodel;

import java.util.HashMap;
import java.util.Map;

public class Transition {
	private String event = null;
	private State target = null;
	//Operation
	private String op = "NONE";
	//Variable
	private String var = null;
	//Condition
	private String con = "NONE";
	
	private Map<String,Integer> varMap = new HashMap<>();
	private Map<String,Integer> conMap = new HashMap<>();
	
	public Transition(String event,State target) {
		this.event = event;
		this.target = target;
	}
	
	public String getEvent() {
		return this.event;
	}

	public State getTarget() {
		return this.target;
	}

	public boolean hasSetOperation() {
		return this.op == "SET" ? true: false;
	}

	public boolean hasIncrementOperation() {
		return this.op == "INCREMENT" ? true: false;
	}

	public boolean hasDecrementOperation() {
		return this.op == "DECREMENT" ? true: false;
	}

	public String getOperationVariableName() {
		return this.var;
	}

	public boolean isConditional() {
		return this.con != "NONE" ? true: false;
	}

	public String getConditionVariableName() {
		return this.var;
	}

	public Integer getConditionComparedValue() {
		return this.conMap.get(this.var);
	}

	public boolean isConditionEqual() {
		return this.con == "EQUALS" ? true: false;
	}

	public boolean isConditionGreaterThan() {
		return this.con == "GREATER" ? true: false;
	}

	public boolean isConditionLessThan() {
		return this.con == "LESS" ? true: false;
	}

	public boolean hasOperation() {
		return this.op != "NONE" ? true: false;
	}
	
	
	
	//For setting and getting operations
	public void setOp(String op, String var) {
		this.op = op;
		this.var = var;
	}
	
	public String getOp() {
		return this.op;
	}
	
	//For setting and getting condition
	public void setCon(String con, int val, String var) {
		this.con = con;
		this.var = var;
		this.conMap.put(var, val);
	}
	
	public String getCon() {
		return this.con;
	}
	
	//Testing
	public Map<String, Integer> getConMap(){
		return this.conMap;
	}
	
	public Map<String, Integer> getVarMap(){
		return this.varMap;
	}


}
