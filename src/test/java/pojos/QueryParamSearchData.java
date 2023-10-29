package pojos;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "validData", "inValidData" })
@Generated("jsonschema2pojo")
public class QueryParamSearchData {

	@JsonProperty("validData")
	private List<ValidData> validData;
	@JsonProperty("inValidData")
	private List<InValidData> inValidData;
	
	@JsonProperty("validData")
	public List<ValidData> getValidData() {
		return validData;
	}
	
	@JsonProperty("validData")
	public void setValidData(List<ValidData> validData) {
		this.validData = validData;
	}
	
	@JsonProperty("inValidData")
	public List<InValidData> getInValidData() {
		return inValidData;
	}
	
	@JsonProperty("inValidData")
	public void setInValidData(List<InValidData> inValidData) {
		this.inValidData = inValidData;
	}
	
}
