package uca.iut.clermont.view

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
import androidx.core.view.marginStart
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uca.iut.clermont.R

class StartFragment : Fragment(), SensorEventListener {


    private lateinit var ball: ImageView
    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var lastUpdate: Long = 0
    private var xPosition = 600f

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_start, container, false)

        ball = view.findViewById(R.id.ball)
        sensorManager = activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        val buttonFavorite = view.findViewById<ImageButton>(R.id.nextButton)

        buttonFavorite.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_UI)
        lastUpdate = System.currentTimeMillis()
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // not used
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val curTime = System.currentTimeMillis()
            if ((curTime - lastUpdate) > 10) {
                val x = event.values[0] * 6f

                val width = ball.width
                val margin = ball.marginStart
                val maxXPosition = (ball.parent as View).width - width - margin.toFloat()

                val newXPosition = xPosition - x
                if (newXPosition < 0) {
                    xPosition = 0f
                    ball.clearAnimation()
                } else if (newXPosition > maxXPosition) {
                    xPosition = maxXPosition
                    ball.clearAnimation()
                } else {
                    xPosition = newXPosition
                }

                val rotation = x * 5
                ball.post {
                    val rotationDirection = if (x > 0) -1 else 1
                    ball.rotation = ball.rotation + rotationDirection * rotation
                }

                ball.x = xPosition
                lastUpdate = curTime

                ball.animate().x(xPosition)
            }
        }
    }
}

