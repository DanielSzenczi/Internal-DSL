package main;

import java.util.List;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {

	private State currentState = null;
	private Machine machine = null;

	public void run(Machine m) {
		this.machine = m;
		this.currentState = m.getInitialState();
	}

	public State getCurrentState() {
		return this.currentState;
	}

	// This got really messy at some point
	public void processEvent(String event) {
		Transition t = machine.getState(this.currentState.getName()).getTransitionByEvent(event);
		if (t != null && !t.isConditional()) {
			this.currentState = t.getTarget();
		}
		if (t != null && t.isConditional()) {
			int var = this.machine.getFromMap(this.machine.getVarName());
			int con = t.getConditionComparedValue();

			if (t.getCon() == "EQUALS" && var == con) {
				this.currentState = t.getTarget();
			}
			if (t.getCon() == "LESS" && var < con) {
				this.currentState = t.getTarget();
			}
			if (t.getCon() == "GREATER" && var > con) {
				this.currentState = t.getTarget();
			}
		}
	}

	public int getInteger(String var) {
		int i = 0;
		if (this.machine.hasInteger(var)) {
			i = this.machine.getFromMap(var);
		}
		return i;
	}

}
