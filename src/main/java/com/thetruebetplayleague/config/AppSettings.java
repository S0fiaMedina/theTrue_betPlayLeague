package com.thetruebetplayleague.config;



import com.thetruebetplayleague.country.adapters.in.CountryConsoleAdapter;
import com.thetruebetplayleague.country.adapters.out.CountryMySQLAdapter;
import com.thetruebetplayleague.country.application.CountryService;
import com.thetruebetplayleague.country.infrastructure.CountryRepository;
import com.thetruebetplayleague.medicalRol.domain.repository.MedicalRolrepository;
import com.thetruebetplayleague.medicalRol.infrastructure.inbound.controller.MedicalRolController;
import com.thetruebetplayleague.medicalRol.infrastructure.outbound.MedicalRolMySQLAdapter;
import com.thetruebetplayleague.team.adapters.in.TeamConsoleAdapter;
import com.thetruebetplayleague.team.adapters.out.TeamAdapterMySQL;
import com.thetruebetplayleague.team.adapters.out.TeamAdapterStatsMySQL;
import com.thetruebetplayleague.team.application.TeamService;
import com.thetruebetplayleague.team.infrastructure.StatsTeamRepository;
import com.thetruebetplayleague.team.infrastructure.TeamRepository;
import com.thetruebetplayleague.teamMember.adapter.in.TeamMemberConsoleAdapter;
import com.thetruebetplayleague.teamMember.adapter.out.TeamMemberAdapterMySQL;
import com.thetruebetplayleague.teamMember.application.TeamMemberService;
import com.thetruebetplayleague.teamMember.infrastructure.TeamMemberRepository;


public class AppSettings {
    // equipo
    private final TeamRepository teamRepository;
    private final StatsTeamRepository statsTeamRepository;

    //miembros de equipo
    private final TeamMemberRepository teamMemberRepository;

    //otros...
    private final CountryRepository countryRepository;
    

    String url = "jdbc:mysql://localhost:3306/betplayLeague";
    String user = "campus2023";
    String pass = "campus2023";

    public AppSettings(){

        this.teamRepository = new TeamAdapterMySQL(url, user, pass);
        this.statsTeamRepository = new TeamAdapterStatsMySQL(url, user, pass);

        this.teamMemberRepository =  new TeamMemberAdapterMySQL(this.url, this.user, this.pass);

        this.countryRepository = new CountryMySQLAdapter(this.url, this.user, this.pass);
    }


        
    

    public  TeamConsoleAdapter startTeamModule(){
        TeamService teamService = new TeamService(teamRepository, statsTeamRepository);
        return new TeamConsoleAdapter(teamService);
    }

    public TeamMemberConsoleAdapter startTeamMemberModule(){
        TeamMemberService teamMemberService = new TeamMemberService(teamMemberRepository, countryRepository, teamRepository);
        return new TeamMemberConsoleAdapter(teamMemberService);
    }

    public CountryConsoleAdapter startCountryModule(){ 
        CountryService countryService = new CountryService(countryRepository);
        return new CountryConsoleAdapter(countryService);
    }

    public MedicalRolController startMedicalRolModule(){
        MedicalRolrepository medicalRolrepository = new MedicalRolMySQLAdapter(this.url, this.user, this.pass);
        return new MedicalRolController(medicalRolrepository); 
    }

    





}
