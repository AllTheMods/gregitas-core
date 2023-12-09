package com.allthemods.gravitas2.material;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.common.data.GTElements;

@SuppressWarnings("unused")
public class GregitasElements {

    public static final Element WeaponsGradeNaquadah = GTElements.createAndRegister(174, 351, 140, null, "WeaponsGradeNaquadah", "Nq++", true);
    public static final Element Hypogen = GTElements.createAndRegister(183, 426, 80, null, "Hypogen", "Hy", false);
    public static final Element Hypogen422 = GTElements.createAndRegister(183, 422, 80, null, "Hypogen-422", "Hy-422", true);
    public static final Element Hypogen414 = GTElements.createAndRegister(183, 414, 80, null, "Hypogen-414", "Hy-414", true);
    public static final Element Hypogen403 = GTElements.createAndRegister(183, 403, 80, null, "Hypogen-403", "Hy-403", true);
    public static final Element InfinityMatter = GTElements.createAndRegister(1000, 1000, -1, null, "InfinityMatter", "Inf", false);
    public static final Element Time = GTElements.createAndRegister(183, 403, -1, null, "Time", "Tim", false);
    public static final Element AllTheModium = GTElements.createAndRegister(127, 201, -1, null, "Allthemodium", "Atm", false);
    public static final Element Unobtainium = GTElements.createAndRegister(128, 206, -1, null, "Unobtainium", "Un", false);
    public static final Element Certus = GTElements.createAndRegister(14, 18, -1, null, "Certus", "Ct", false);
    
    public static void init() {
        
    }
}
