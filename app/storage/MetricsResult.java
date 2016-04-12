package storage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table (name = "metrics_result")
public class MetricsResult extends Model implements IStorage {

	private static final long serialVersionUID = 1L;

	@Id    
	@Column (name = "id", nullable = false)                                    
	@GeneratedValue (strategy = GenerationType.IDENTITY)                                    
	private Integer id;

	@Column (name = "step_name", length = 256)                                                                       
	private String stepName;

	@Column (name = "copy_nr")                                                                       
	private Integer copyNumber;

	@Column (name = "read_nr")                                                                       
	private Integer readNumber;

	@Column (name = "write_nr")                                                                       
	private Integer writeNumber;

	@Column (name = "input_nr")                                                                       
	private Integer inputNumber;

	@Column (name = "output_nr")                                                                       
	private Integer outputNumber;

	@Column (name = "updated")                                                                       
	private Integer updated;

	@Column (name = "rejected")                                                                       
	private Integer rejected;

	@Column (name = "errors")                                                                       
	private Integer errors;

	@Column (name = "status", length = 256)                                                                       
	private String status;

	@Column (name = "runtime")                                                                       
	private Integer runtime;
	
	@Column (name = "machineId")
	private Integer machineId;

	@Column (name = "flowId")
	private String flowId;

	@Column (name = "timestamp")
	private String timestamp;

	@Override
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	@Override
	public void setCopyNumber(Integer copyNumber) {
		this.copyNumber = copyNumber;
	}

	@Override
	public void setReadNumber(Integer readNumber) {
		this.readNumber = readNumber;
	}

	@Override
	public void setWriteNumber(Integer writeNumber) {
		this.writeNumber = writeNumber;
	}

	@Override
	public void setInputNumber(Integer inputNumber) {
		this.inputNumber = inputNumber;
	}

	@Override
	public void setOutputNumber(Integer outputNumber) {
		this.outputNumber = outputNumber;
	}

	@Override
	public void setUpdated(Integer updated) {
		this.updated = updated;
	}

	@Override
	public void setRejected(Integer rejected) {
		this.rejected = rejected;
	}

	@Override
	public void setErrors(Integer errors) {
		this.errors = errors;
	}

	@Override
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	
	@Override
	public void setFileName(String name) {}

	@Override
	public void setMachineId(Integer machineId) {
		this.machineId = machineId;
		
	}

	@Override
	public void setFlowId(String flowId) {
		this.flowId = flowId;
		
	}

	@Override
	public void setTimeStamp(String timestamp) {
		this.timestamp = timestamp;
		
	}
}
