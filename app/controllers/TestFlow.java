package controllers;

import java.util.ArrayList;
import java.util.Map;

public interface TestFlow {
	
		public String getFilepath();

		public FlowCategory getFlowCategory();

		public FlowPhase getFlowPhase();

		public int getFlowId();
		
		public String getFileName();
		
		public ArrayList<Integer> getPreInitUtils();
		
		public ArrayList<Integer> getInitUtils();
		
		public Map<Integer, ArrayList<Double>> getDataUtils();
		
		public ArrayList<Integer> getCompenUtils();
	
}
