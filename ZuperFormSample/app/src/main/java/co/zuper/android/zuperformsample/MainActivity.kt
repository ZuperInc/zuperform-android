package co.zuper.android.zuperformsample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import co.zuper.android.zuperforms.ZuperForm

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_launch_form).setOnClickListener {
            ZuperForm.launch()

        }
    }
}
