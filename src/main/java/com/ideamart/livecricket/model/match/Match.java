
package com.ideamart.livecricket.model.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "unique_id",
    "date",
    "squad",
    "team-2",
    "team-1",
    "matchStarted"
})
public class Match {

    @JsonProperty("unique_id")
    private Integer uniqueId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("squad")
    private Boolean squad;
    @JsonProperty("team-2")
    private String team2;
    @JsonProperty("team-1")
    private String team1;
    @JsonProperty("matchStarted")
    private Boolean matchStarted;

    @JsonProperty("unique_id")
    public Integer getUniqueId() {
        return uniqueId;
    }

    @JsonProperty("unique_id")
    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("squad")
    public Boolean getSquad() {
        return squad;
    }

    @JsonProperty("squad")
    public void setSquad(Boolean squad) {
        this.squad = squad;
    }

    @JsonProperty("team-2")
    public String getTeam2() {
        return team2;
    }

    @JsonProperty("team-2")
    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    @JsonProperty("team-1")
    public String getTeam1() {
        return team1;
    }

    @JsonProperty("team-1")
    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    @JsonProperty("matchStarted")
    public Boolean getMatchStarted() {
        return matchStarted;
    }

    @JsonProperty("matchStarted")
    public void setMatchStarted(Boolean matchStarted) {
        this.matchStarted = matchStarted;
    }

}
