/*
 * Copyright (c) 2017 Daimler AG / Moovel GmbH
 *
 * All rights reserved
 */

package com.car2go.maps;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

/**
 * View container for an {@link AnyMap}.
 */
public abstract class MapContainerView extends FrameLayout {

	OnInterceptTouchEvent callback;

	protected MapContainerView(Context context) {
		super(context);
	}

	protected MapContainerView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * Gets the wrapped {@link AnyMap} asynchronously.
	 *
	 * @param callback the callback to use when the map has been got
	 */
	public abstract void getMapAsync(OnMapReadyCallback callback);

	/**
	 * Propagate the onCreate lifecycle call to the AnyMap.
	 *
	 * @param savedInstanceState the savedInstanceState
	 */
	public abstract void onCreate(Bundle savedInstanceState);

	/**
	 * Propagate the onResume lifecycle call to the AnyMap.
	 */
	public abstract void onResume();

	/**
	 * Propagate the onPause lifecycle call to the AnyMap.
	 */
	public abstract void onPause();

	/**
	 * Propagate the onDestroy lifecycle call to the AnyMap.
	 */
	public abstract void onDestroy();

	/**
	 * Propagate the onLowMemory lifecycle call to the AnyMap.
	 */
	public abstract void onLowMemory();

	/**
	 * Propagate the onSaveInstanceState lifecycle call to the AnyMap.
	 *
	 * @param outState the outState
	 */
	public abstract void onSaveInstanceState(Bundle outState);

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		if (callback != null) callback.onInterceptTouchEvent(ev);
		return super.onInterceptTouchEvent(ev);
	}

	public void setOnInterceptTouchEventListener(OnInterceptTouchEvent callback) {
		this.callback = callback;
	}
}
