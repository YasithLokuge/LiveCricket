
package com.ideamart.livecricket.model.match;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "source",
    "url",
    "pubDate"
})
public class Provider {

    @JsonProperty("source")
    private String source;
    @JsonProperty("url")
    private String url;
    @JsonProperty("pubDate")
    private String pubDate;

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("pubDate")
    public String getPubDate() {
        return pubDate;
    }

    @JsonProperty("pubDate")
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

}
