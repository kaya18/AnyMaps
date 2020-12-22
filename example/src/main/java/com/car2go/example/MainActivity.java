/*
 * Copyright (c) 2017 Daimler AG / Moovel GmbH
 *
 * All rights reserved
 */

package com.car2go.example;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.car2go.maps.AnyMap;
import com.car2go.maps.MapContainerView;
import com.car2go.maps.OnMapReadyCallback;
import com.car2go.maps.model.LatLng;
import com.car2go.maps.model.MarkerOptions;
import com.car2go.maps.osm.BitmapDescriptorFactory;
import com.car2go.maps.osm.CameraUpdateFactory;
import com.car2go.maps.osm.MapsConfiguration;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

	private MapContainerView mapView;
	private LocationManager mLocService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mLocService = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Location loc = mLocService.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		final Double longitude = loc.getLongitude();
		final Double latitude = loc.getLatitude();

		MapsConfiguration.getInstance().initialize(this);

		mapView = (MapContainerView) findViewById(R.id.map_view);

		mapView.onCreate(savedInstanceState);

		mapView.getMapAsync(new OnMapReadyCallback() {
			@Override
			public void onMapReady(AnyMap anyMap) {
				anyMap.moveCamera(
						CameraUpdateFactory.getInstance()
								.newLatLngZoom(new LatLng(latitude, longitude), 21.5f)
				);

				anyMap.addMarker(
						new MarkerOptions()
								.position(new LatLng(latitude, longitude)).anchor(0.1f, 0.1f).icon(BitmapDescriptorFactory.getInstance().fromResource(R.drawable.marker)
						)
				);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();

		mapView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();

		mapView.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		mapView.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);

		mapView.onSaveInstanceState(outState);
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();

		mapView.onLowMemory();
	}

}
