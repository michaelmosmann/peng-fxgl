package de.mosmann.peng

import com.almasb.fxgl.app.GameApplication

object PengAppStarter {
    @JvmStatic
    fun main(args: Array<String>) {
        GameApplication.launch(PengApp::class.java, args)
    }
}