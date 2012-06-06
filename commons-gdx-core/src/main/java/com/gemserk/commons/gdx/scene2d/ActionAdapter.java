package com.gemserk.commons.gdx.scene2d;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActionAdapter extends Action {
	
	protected Actor target;
	protected boolean done;
	
	public void setDone(boolean done) {
		this.done = done;
	}
	
	public ActionAdapter() {
		done = false;
	}

	@Override
	public void setTarget(Actor target) {
		this.target = target;
	}

	@Override
	public Actor getTarget() {
		return target;
	}

	@Override
	public void act(float delta) {
		
	}

	@Override
	public boolean isDone() {
		return done;
	}

	@Override
	public Action copy() {
		ActionAdapter actionAdapter = new ActionAdapter();
		actionAdapter.target = this.target;
		actionAdapter.done = this.done;
		return actionAdapter;
	}

}
