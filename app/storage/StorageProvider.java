package storage;

public class StorageProvider implements IStorageProvider {
	
	public IStorage getStorage(String name) {
		IStorage storage = null;
		switch (name) {
		case "xml":
			storage = new MetricsResultXML();
		case "postgres":
			storage = new MetricsResult();
		}
		return storage;
	}

}
