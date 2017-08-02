package com.deltadax.views_example;

import android.app.Application;

import com.deltadax.views_example.entity.ListItem;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by JosePablo on 01/08/17.
 * Application
 */

public class ViewsApps extends Application {

    public static ArrayList<ListItem> getItems() {
        ArrayList<ListItem> lista = new ArrayList<>();

        Random r = new Random();
        int Low = 50;
        int High = 100;

        lista.add(new ListItem("THE PROFUNDITY",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/the-profundity-main_b7347934.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("X-WING STARFIGHTER",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/X-Wing-Fighter_47c7c342.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("TIE FIGHTER",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/TIE-Fighter_25397c64.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("THE GHOST",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/the-ghost-s3_499fca79.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("IMPERIAL STAR DESTROYER",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/Star-Destroyer_ab6b94bb.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("HAMMERHEAD CORVETTE",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/hammerhead-corvette-rogue-update_453ce60b.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("THE GHOST",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/the-ghost-s3_499fca79.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("TIE STRIKER",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/tie-striker_21f90de5.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("TANTIVE IV",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/databank_tantiveiv_01_169_1c9b8f5d.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("DEATH STAR",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/Death-Star-I-copy_36ad2500.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("A-WING FIGHTER",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/screen_shot_2015-05-26_at_5_16a39e17.png",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("DARTH VADER'S TIE FIGHTER",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/vaders-tie-fighter_8bcb92e1.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("ARC-170 STARFIGHTER",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/databank_arc170starfighter_01_169_f932abcb.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("EXECUTOR",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/databank_executor_01_169_8157df82.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("U-WING",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/u-wing_3a89a295.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("IMPERIAL GOZANTI-CLASS CRUISER",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/image_c5bf105d.jpeg",
                r.nextInt(High - Low) + Low));

        lista.add(new ListItem("B-WING FIGHTER",
                C.state_active,
                "https://lumiere-a.akamaihd.net/v1/images/databank_bwingfighter_01_169_460cc528.jpeg",
                r.nextInt(High - Low) + Low));

        return lista;
    }

}
