/*
 * Copyright (c) 2017 Daimler AG / Moovel GmbH
 *
 * All rights reserved
 */

package com.car2go.maps;

import android.graphics.Bitmap;

import com.car2go.maps.model.BitmapDescriptor;

import androidx.annotation.DrawableRes;

/**
 * Factory for creating BitmapDescriptors.
 */
public interface BitmapDescriptorFactory {
	/**
	 * @return new {@link BitmapDescriptor} from given {@link Bitmap}
	 */
	BitmapDescriptor fromBitmap(Bitmap bitmap);

	/**
	 * @return new {@link BitmapDescriptor} from given resource
	 */
	BitmapDescriptor fromResource(@DrawableRes int resourceId);
}
