package com.thetruebetplayleague;

import com.thetruebetplayleague.Modules.city.adapter.in.CityConsoleAdapter;
import com.thetruebetplayleague.Modules.country.adapter.in.CountryConsoleAdapter;
import com.thetruebetplayleague.Modules.stadium.adapter.in.StadiumConsoleAdapter;
import com.thetruebetplayleague.console.Initializer;
import com.thetruebetplayleague.console.Util;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/liga_betplay";
        String user = "root";
        String password = "R00T_12345";
        Initializer initializer = new Initializer(url, user, password);

        CountryConsoleAdapter countryConsoleAdapter = initializer.startCountryModule();
        CityConsoleAdapter cityConsoleAdapter = initializer.startCityModule();
        StadiumConsoleAdapter stadiumConsoleAdapter = initializer.startStadiumModule();



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
            "▶ ( 4 ) Estadios",
            "▶ ( 5 ) Ciudades",
            "▶ ( 6 ) Paises",
            "▶ ( 7 ) salir"

        };

        System.out.println(header);

        boolean breaker = true;

        while (breaker){
            Util.printOptions(mainOptions);
            int op = Util.rangeValidator(1, mainOptions.length);

            switch (op) {
                case 4:
                    stadiumConsoleAdapter.run();
                    break;
                case 5:
                    cityConsoleAdapter.run();
                    break;
                case 6:
                    countryConsoleAdapter.run();
                    break;
            
                default:
                    breaker = false;
            }
        }
        

        
    }
}
