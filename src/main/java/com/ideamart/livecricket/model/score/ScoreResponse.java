
package com.ideamart.livecricket.model.score;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "provider",
    "ttl",
    "v",
    "cache",
    "matchStarted",
    "team-2",
    "team-1",
    "dateTimeGMT",
    "type",
    "score",
    "innings-requirement",
    "cache2"
})
public class ScoreResponse {

    @JsonProperty("provider")
    private Provider provider;
    @JsonProperty("ttl")
    private Integer ttl;
    @JsonProperty("v")
    private String v;
    @JsonProperty("cache")
    private Boolean cache;
    @JsonProperty("matchStarted")
    private Boolean matchStarted;
    @JsonProperty("team-2")
    private String team2;
    @JsonProperty("team-1")
    private String team1;
    @JsonProperty("dateTimeGMT")
    private String dateTimeGMT;
    @JsonProperty("type")
    private String type;
    @JsonProperty("score")
    private String score;
    @JsonProperty("innings-requirement")
    private String inningsRequirement;
    @JsonProperty("cache2")
    private Boolean cache2;

    @JsonProperty("provider")
    public Provider getProvider() {
        return provider;
    }

    @JsonProperty("provider")
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @JsonProperty("ttl")
    public Integer getTtl() {
        return ttl;
    }

    @JsonProperty("ttl")
    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    @JsonProperty("v")
    public String getV() {
        return v;
    }

    @JsonProperty("v")
    public void setV(String v) {
        this.v = v;
    }

    @JsonProperty("cache")
    public Boolean getCache() {
        return cache;
    }

    @JsonProperty("cache")
    public void setCache(Boolean cache) {
        this.cache = cache;
    }

    @JsonProperty("matchStarted")
    public Boolean getMatchStarted() {
        return matchStarted;
    }

    @JsonProperty("matchStarted")
    public void setMatchStarted(Boolean matchStarted) {
        this.matchStarted = matchStarted;
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

    @JsonProperty("dateTimeGMT")
    public String getDateTimeGMT() {
        return dateTimeGMT;
    }

    @JsonProperty("dateTimeGMT")
    public void setDateTimeGMT(String dateTimeGMT) {
        this.dateTimeGMT = dateTimeGMT;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("score")
    public String getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(String score) {
        this.score = score;
    }

    @JsonProperty("innings-requirement")
    public String getInningsRequirement() {
        return inningsRequirement;
    }

    @JsonProperty("innings-requirement")
    public void setInningsRequirement(String inningsRequirement) {
        this.inningsRequirement = inningsRequirement;
    }

    @JsonProperty("cache2")
    public Boolean getCache2() {
        return cache2;
    }

    @JsonProperty("cache2")
    public void setCache2(Boolean cache2) {
        this.cache2 = cache2;
    }

}
