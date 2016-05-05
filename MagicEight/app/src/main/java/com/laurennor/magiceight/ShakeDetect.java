//package com.laurennor.magiceight;
//
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//
//// Create a class that implements SensorEventListener
//public class ShakeDetect implements SensorEventListener {
//
//    // Declare member variables to define the shake movements
//    private static final int MIN_SHAKE_COUNT = 3;
//    private static final int SHAKE_MOVEMENT = 2;
//    private static final int MAX_SHAKE_TIME = 100;
//
//    // Declare a member variable for shake detection
//    private OnShakeListener mOnShakeListener;
//
//    // Start time shake detection
//    long shakeStartTime = 0;
//    // Count shake movements
//    int movementCount = 0;
//
//    // Create a constructor for the sh
//    public ShakeDetect(OnShakeListener shakeListener) {
//        mOnShakeListener = shakeListener;
//    }
//
//
//    @Override
//    // Create a method that will be called when a change is detected
//    public void onSensorChanged(SensorEvent event){
//
//
//        setAcceleration(event);
//
//        float maxLinAcceleration = getMaxLinAcceleration();
//
//        // Get maxLinearAcceleration
//        if (maxLinAcceleration > MIN_SHAKE_COUNT){
//            long current = System.currentTimeMillis();
//
//            //
//            if(shakeStartTime == 0){
//                shakeStartTime = current;
//            }
//
//            long elapsedTime = current - shakeStartTime;
//            if (elapsedTime > MAX_SHAKE_TIME){
//                resetShakeDetection();
//            }else {
//                movementCount++;
//
//                if (movementCount > MIN_SHAKE_COUNT){
//                    mOnShakeListener.o
//                }
//            }
//        }
//    }
//
//    private void resetShakeDetection() {
//    }
//
//    private float getMaxLinAcceleration() {
//        return 0;
//    }
//
//
//    private void setAcceleration(SensorEvent event){
//        // alpha is calculated as t / (t + dT)
//        // with t, the low-pass filter's time-constant
//        // and dT, the event delivery rate
//
//        final float alpha = 0.8;
//
//        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
//        gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
//        gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];
//
//        linear_acceleration[0] = event.values[0] - gravity[0];
//        linear_acceleration[1] = event.values[1] - gravity[1];
//        linear_acceleration[2] = event.values[2] - gravity[2];
//    }
//
//
//
//}
