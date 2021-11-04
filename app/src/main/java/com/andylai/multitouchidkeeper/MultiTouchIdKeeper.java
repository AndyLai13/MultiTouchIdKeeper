package com.andylai.multitouchidkeeper;

import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.Collections;

public class MultiTouchIdKeeper extends ArrayList<Integer> {
	private static final int defaultValue = -1;
	private int index = 0;

	public MultiTouchIdKeeper(int maxAmount) {
		super(Collections.nCopies(maxAmount, defaultValue));
		dump();
	}

	public void resetAll() {
		for (int i = 0; i < size(); i++) {
			set(i, -1);
		}
	}

	public void reset(int id) {
		if (!contains(id)) return;
		for (int i = 0; i < size(); i++) {
			if (get(i) == id) {
				set(i, -1);
			}
		}
	}

	public void dump() {
		for (int i = 0; i < size(); i++) {
			Log.d("Andy", "(i, value) = " + i + "," + get(i));
		}
	}

	public int getIndex() {
		return index;
	}

	public void actionDown(MotionEvent event) {
		index = 0;
		int actionIndex = event.getActionIndex();
		int pointerId = event.getPointerId(actionIndex);
		set(index, pointerId);
		dump();
	}

	public void actionPointerDown(MotionEvent event) {
		int actionIndex = event.getActionIndex();
		int pointerId = event.getPointerId(actionIndex);
		index++;
		set(index, pointerId);
		dump();
	}

	public void actionMove(MotionEvent event) {

	}

	public void actionPointerUp(MotionEvent event) {
		int actionIndex = event.getActionIndex();
		int pointerId = event.getPointerId(actionIndex);
		reset(pointerId);
		dump();
	}

	public void actionUp(MotionEvent event) {
		index = 0;
		resetAll();
		dump();
	}
}
