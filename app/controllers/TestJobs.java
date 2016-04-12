package controllers;

import java.util.ArrayList;
import java.util.Map;

public enum TestJobs implements TestFlow,  TestJob {
	dimAccountUpdateJobHU(){

		@Override
		public String getFilepath() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public FlowCategory getFlowCategory() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public FlowPhase getFlowPhase() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getFlowId() {
			// TODO Auto-generated method stub
			return 17;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "JobUpdateDimAccount.kjb";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.accountKeysDelete.getId());
			init.add(UtilityTransformations.dimAccountDelete.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.dimDate.getId());
			preInit.add(UtilityTransformations.dimBroker.getId());
			preInit.add(UtilityTransformations.taxRate.getId());
			preInit.add(UtilityTransformations.dimCustomer.getId());
			preInit.add(UtilityTransformations.dimAccount.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getTransformations() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
	

	
