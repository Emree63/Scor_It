package uca.iut.clermont.view

import android.animation.ObjectAnimator
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uca.iut.clermont.R


class StartFragment : Fragment(), SensorEventListener {

    private lateinit var ball: ImageView
    private lateinit var sensorManager: SensorManager
    private lateinit var accelerometer: Sensor
    private var lastX = 0f
    private var lastY = 0f
    private var lastZ = 0f


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_start, container, false)

        ball = view.findViewById(R.id.ball)

        sensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)

        val buttonFavorite = view.findViewById<ImageButton>(R.id.nextButton)

        buttonFavorite.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

        return view
    }


    override fun onSensorChanged(event: SensorEvent) {
        val x = event.values[0]
        val y = event.values[1]
        val z = event.values[2]

        val angleX = x / 9.81f
        val angleY = y / 9.81f

        if (Math.abs(angleX) > 0.1) {
            val deltaX = angleX * 20f * if (angleX > 0) 1 else -1
            ObjectAnimator.ofFloat(ball, View.TRANSLATION_X, ball.x + deltaX).start()

            ObjectAnimator.ofFloat(ball, View.ROTATION, angleX * 3400f).start()
        }

        lastX = x
        lastY = y
        lastZ = z
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

}