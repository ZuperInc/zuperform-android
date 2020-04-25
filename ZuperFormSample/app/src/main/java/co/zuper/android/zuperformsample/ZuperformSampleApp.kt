package co.zuper.android.zuperformsample

import android.app.Application
import co.zuper.android.zuperforms.ZuperForm
import co.zuper.android.zuperforms.ZuperFormConfig

class ZuperformSampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ZuperForm.init(
            applicationContext,
            ZuperFormConfig(
                "b64dc4c0-80b4-11ea-9c5a-93fd87cd1c39",
                "My Company",
                "https://zuper.co/img/logo_trans.png"
            )
        )
    }
}