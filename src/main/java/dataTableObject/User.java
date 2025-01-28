package dataTableObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

//someThing we will not send in request and not come in response
//we want more cleaner ,thats why we have to use @JsonInclude
@JsonInclude(Include.NON_NULL)
public class User {//POZO class
	private String first_name;
	private String last_name;
	private String job;
	private String createdAt;
	private int id;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCreateAt() {
		return createdAt;
	}

	public void setCreateAt(String createAt) {
		this.createdAt = createAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
