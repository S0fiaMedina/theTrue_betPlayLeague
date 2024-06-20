package com.thetruebetplayleague.teamMember.infrastructure;

import com.thetruebetplayleague.teamMember.domain.model.TeamMember;

public interface TeamMemberRepository {
    public int save(TeamMember teamMember);
    

}
