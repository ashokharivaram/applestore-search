package pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "term", "country", "callback", "limit", "lang", "version", "explicit", "media", "entity",
		"attribute" })
public class Data {

	@JsonProperty("term")
	private String term;
	@JsonProperty("country")
	private String country;
	@JsonProperty("callback")
	private String callback;
	@JsonProperty("limit")
	private String limit;
	@JsonProperty("lang")
	private String lang;
	@JsonProperty("version")
	private String version;
	@JsonProperty("explicit")
	private String explicit;
	@JsonProperty("media")
	private String media;
	@JsonProperty("entity")
	private String entity;
	@JsonProperty("attribute")
	private String attribute;

	@JsonProperty("term")
	public String getTerm() {
		return term;
	}

	@JsonProperty("term")
	public void setTerm(String term) {
		this.term = term;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("callback")
	public String getCallback() {
		return callback;
	}

	@JsonProperty("callback")
	public void setCallback(String callback) {
		this.callback = callback;
	}

	@JsonProperty("limit")
	public String getLimit() {
		return limit;
	}

	@JsonProperty("limit")
	public void setLimit(String limit) {
		this.limit = limit;
	}

	@JsonProperty("lang")
	public String getLang() {
		return lang;
	}

	@JsonProperty("lang")
	public void setLang(String lang) {
		this.lang = lang;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}

	@JsonProperty("explicit")
	public String getExplicit() {
		return explicit;
	}

	@JsonProperty("explicit")
	public void setExplicit(String explicit) {
		this.explicit = explicit;
	}

	@JsonProperty("media")
	public String getMedia() {
		return media;
	}

	@JsonProperty("media")
	public void setMedia(String media) {
		this.media = media;
	}

	@JsonProperty("entity")
	public String getEntity() {
		return entity;
	}

	@JsonProperty("entity")
	public void setEntity(String entity) {
		this.entity = entity;
	}

	@JsonProperty("attribute")
	public String getAttribute() {
		return attribute;
	}

	@JsonProperty("attribute")
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

}