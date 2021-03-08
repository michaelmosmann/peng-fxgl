package de.mosmann.peng

import com.almasb.fxgl.app.GameApplication
import com.almasb.fxgl.app.GameSettings

class PengApp : GameApplication() {
    override fun initSettings(settings: GameSettings?) {
        // initialize common game / window settings.
        settings!!.title = "Peng"
        settings.version = "1.0"
        settings.width = 480
        settings.height = 800
    }
}

