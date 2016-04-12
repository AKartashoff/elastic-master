package storage;

public interface IStorage {

	void setStepName(String stepName);

	void setCopyNumber(Integer copyNumber);

	void setReadNumber(Integer readNumber);

	void setWriteNumber(Integer writeNumber);

	void setInputNumber(Integer inputNumber);

	void setOutputNumber(Integer outputNumber);

	void setUpdated(Integer updated);

	void setRejected(Integer rejected);

	void setErrors(Integer errors);

	void setStatus(String status);

	void setRuntime(Integer runtime);

	void setFileName(String name);

	void save();

	void setMachineId(Integer machineID);

	void setFlowId(String flowId);

	void setTimeStamp(String timestamp);
}
