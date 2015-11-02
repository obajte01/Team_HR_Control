package com.teamhrcontrol.teamhrcontrol;

import android.app.Service;
import android.content.Intent;
import android.net.nsd.NsdManager;
import android.os.IBinder;

import com.wahoofitness.connector.HardwareConnector;
import com.wahoofitness.connector.HardwareConnectorEnums;
import com.wahoofitness.connector.HardwareConnectorTypes;
import com.wahoofitness.connector.conn.connections.SensorConnection;
import com.wahoofitness.connector.conn.connections.params.ConnectionParams;
import com.wahoofitness.connector.listeners.discovery.DiscoveryListener;

public class TeamHR extends Service {
    private HardwareConnector mHardwareConnector;
    private final HardwareConnector.Callback mHardwareConnectorCallback = new HardwareConnector.Callback(){
        @Override
        public void connectorStateChanged(HardwareConnectorTypes.NetworkType networkType, HardwareConnectorEnums.HardwareConnectorState hardwareConnectorState) {

        }

        @Override
        public void connectedSensor(SensorConnection sensorConnection) {

        }

        @Override
        public void disconnectedSensor(SensorConnection sensorConnection) {

        }

        @Override
        public void hasData() {

        }

        @Override
        public void onFirmwareUpdateRequired(SensorConnection sensorConnection, String s, String s1) {

        }
    };

    public DiscoveryListener listener = new DiscoveryListener() {
        @Override
        public void onDeviceDiscovered(ConnectionParams connectionParams) {

        }

        @Override
        public void onDiscoveredDeviceLost(ConnectionParams connectionParams) {

        }

        @Override
        public void onDiscoveredDeviceRssiChanged(ConnectionParams connectionParams, int i) {

        }
    };

    public TeamHR() {
    }
    @Override
    public void onCreate(){
        super.onCreate();
        mHardwareConnector = new HardwareConnector(this, mHardwareConnectorCallback);
        mHardwareConnector.startDiscovery(HardwareConnectorTypes.SensorType.HEARTRATE, HardwareConnectorTypes.NetworkType.BTLE, listener);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mHardwareConnector.shutdown();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
