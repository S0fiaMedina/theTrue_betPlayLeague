package com.thetruebetplayleague;

import com.thetruebetplayleague.Modules.Country.adapter.in.CountryConsoleAdapter;
import com.thetruebetplayleague.console.Initializer;
import com.thetruebetplayleague.console.Util;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/liga_betplay";
        String user = "root";
        String password = "R00T_12345";
        Initializer initializer = new Initializer(url, user, password);

        CountryConsoleAdapter countryConsoleAdapter = initializer.startCountryModule();



        String header = """
        ██╗     ██╗ ██████╗  █████╗     ██████╗ ███████╗████████╗██████╗ ██╗      █████╗ ██╗   ██╗
        ██║     ██║██╔════╝ ██╔══██╗    ██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝
        ██║     ██║██║  ███╗███████║    ██████╔╝█████╗     ██║   ██████╔╝██║     ███████║ ╚████╔╝ 
        ██║     ██║██║   ██║██╔══██║    ██╔══██╗██╔══╝     ██║   ██╔═══╝ ██║     ██╔══██║  ╚██╔╝  
        ███████╗██║╚██████╔╝██║  ██║    ██████╔╝███████╗   ██║   ██║     ███████╗██║  ██║   ██║   
        ╚══════╝╚═╝ ╚═════╝ ╚═╝  ╚═╝    ╚═════╝ ╚══════╝   ╚═╝   ╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   
                """;

        String[] mainOptions ={
            "▶ ( 1 ) Partidos",
            "▶ ( 2 ) Jugadores",
            "▶ ( 3 ) Equipos",
            "▶ ( 4 ) Ciudades",
            "▶ ( 5 ) Paises"
        };

        System.out.println(header);
        Util.printOptions(mainOptions);
        int op = Util.rangeValidator(1, mainOptions.length);

        switch (op) {
            case 5:
                countryConsoleAdapter.run();
                break;
        
            default:
                break;
        }

        
    }
}
