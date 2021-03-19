module de.mosmann.peng {
    requires com.almasb.fxgl.all;
    requires kotlin.stdlib;
    exports de.mosmann.peng;

    opens assets.music;
    opens assets.sounds;
    opens assets.textures;
}