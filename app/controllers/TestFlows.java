package controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum TestFlows implements TestFlow {

	dimCustomer (){

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
			return 0;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "DimCustomer.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.taxRate.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.customerKeysDelete.getId());
			preInit.add(UtilityTransformations.dimCustomerDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.ProspectInput.getNullPercentage());
			parameters.add(DataUtilityETLs.ProspectInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.ProspectInput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.jobTaxRateOutput.getNullPercentage());
			parameters.add(DataUtilityETLs.jobTaxRateOutput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.jobTaxRateOutput.getId(), parameters);
			return dataUtils;
		}

	},
	dimBrokerHL() {

		@Override
		public String getFilepath() {
			// old:
			// return "tests/tpcdi/dimBroker_agn.xml";
			return "tests/tpcdi/complete/DimBroker_agn.xml";
		}

		@Override
		public FlowCategory getFlowCategory() {
			return FlowCategory.MEDIUM;
		}

		@Override
		public FlowPhase getFlowPhase() {
			return FlowPhase.HistoricalLoad;
		}

		@Override
		public int getFlowId() {
			return 2;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "DimBroker.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.dimDate.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.brokerKeysDelete.getId());
			preInit.add(UtilityTransformations.dimBrokerDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.dimBrokerInput.getNullPercentage());
			parameters.add(DataUtilityETLs.dimBrokerInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.dimBrokerInput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.jobDimDateOutput.getNullPercentage());
			parameters.add(DataUtilityETLs.jobDimDateOutput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.jobDimDateOutput.getId(), parameters);
			return dataUtils;
		}

	},
	dimAccountHL() {
		@Override
		public String getFilepath() {
			// old:
			// return "tests/tpcdi/dimAccount_agn.xml";
			return "tests/tpcdi/complete/DimAccount_agn.xml";
		}

		@Override
		public FlowCategory getFlowCategory() {
			return FlowCategory.XMLLoading;
		}

		@Override
		public FlowPhase getFlowPhase() {
			return FlowPhase.HistoricalLoad;
		}

		@Override
		public int getFlowId() {
			return 3;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "DimAccount.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.dimDate.getId());
			init.add(UtilityTransformations.dimBroker.getId());
			init.add(UtilityTransformations.taxRate.getId());
			init.add(UtilityTransformations.dimCustomer.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.accountKeysDelete.getId());
			preInit.add(UtilityTransformations.dimAccountDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.dimAccountInput.getNullPercentage());
			parameters.add(DataUtilityETLs.dimAccountInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.dimAccountInput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.jobDimBrokerOutput.getNullPercentage());
			parameters.add(DataUtilityETLs.jobDimBrokerOutput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.jobDimBrokerOutput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.jobDimCustomerOutput.getNullPercentage());
			parameters.add(DataUtilityETLs.jobDimCustomerOutput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.jobDimCustomerOutput.getId(), parameters);
			return dataUtils;
		}

	},

	dimCompanyHL() {

		@Override
		public String getFilepath() {
			// old
			// return "tests/tpcdi/dimCompany_agn.xml";
			return "tests/tpcdi/complete/DimCompany_agn.xml";
		}

		@Override
		public FlowCategory getFlowCategory() {
			return FlowCategory.MEDIUM;
		}

		@Override
		public FlowPhase getFlowPhase() {
			return FlowPhase.HistoricalLoad;
		}

		@Override
		public int getFlowId() {
			return 4;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "DimCompany.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.companyKeysDelete.getId());
			preInit.add(UtilityTransformations.dimCompanyDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.dimCompanyInput.getNullPercentage());
			parameters.add(DataUtilityETLs.dimCompanyInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.dimCompanyInput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.IndustryInput.getNullPercentage());
			parameters.add(DataUtilityETLs.IndustryInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.IndustryInput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.StatusTypeInput.getNullPercentage());
			parameters.add(DataUtilityETLs.StatusTypeInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.StatusTypeInput.getId(), parameters);
			return dataUtils;
		}

	},
	dimSecurityHL() {
		@Override
		public String getFilepath() {
			// old
			// return "tests/tpcdi/dimCompany_agn.xml";
			return "tests/tpcdi/complete/DimSecurity_agn.xml";
		}

		@Override
		public FlowCategory getFlowCategory() {
			return FlowCategory.MEDIUM;
		}

		@Override
		public FlowPhase getFlowPhase() {
			return FlowPhase.HistoricalLoad;
		}

		@Override
		public int getFlowId() {
			return 5;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "DimSecurity.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.dimCompany.getId());
			init.add(UtilityTransformations.statusType.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.securityKeysDelete.getId());
			preInit.add(UtilityTransformations.dimSecurityDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.dimSecurityInput.getNullPercentage());
			parameters.add(DataUtilityETLs.dimSecurityInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.dimSecurityInput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.jobDimCompanyOutput.getNullPercentage());
			parameters.add(DataUtilityETLs.jobDimCompanyOutput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.jobDimCompanyOutput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.jobStatusTypeOutput.getNullPercentage());
			parameters.add(DataUtilityETLs.jobStatusTypeOutput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.jobStatusTypeOutput.getId(), parameters);
			return dataUtils;
		}
	},
	financialHL() {
		@Override
		public String getFilepath() {
			// old
			// return "tests/tpcdi/dimCompany_agn.xml";
			return "tests/tpcdi/complete/Financial_agn.xml";
		}

		@Override
		public FlowCategory getFlowCategory() {
			return FlowCategory.MEDIUM;
		}

		@Override
		public FlowPhase getFlowPhase() {
			return FlowPhase.HistoricalLoad;
		}

		@Override
		public int getFlowId() {
			return 6;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "Financial.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.dimCompany.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.financialDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.FinancialInput.getNullPercentage());
			parameters.add(DataUtilityETLs.FinancialInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.FinancialInput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.jobDimCompanyOutput.getNullPercentage());
			parameters.add(DataUtilityETLs.jobDimCompanyOutput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.jobDimCompanyOutput.getId(), parameters);
			return dataUtils;
		}
	},

	dimDateHl(){

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
			return 1;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "DimDate.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.dimDateDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.dimDateInput.getNullPercentage());
			parameters.add(DataUtilityETLs.dimDateInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.dimDateInput.getId(), parameters);
			return dataUtils;
		}
	},

	dimTimeHL(){

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
			return 7;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "DimTime.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.dimTimeDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.dimTimeInput.getNullPercentage());
			parameters.add(DataUtilityETLs.dimTimeInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.dimTimeInput.getId(), parameters);
			return dataUtils;
		}	
	},

	dimTradePopulateHL(){

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
			return 8;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "DimTradePopulate.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.dimTradeDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	dimTradeUpdateHL(){

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
			return 9;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "DimTradePopulateUpdate.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.dimTradeDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	factcashbalancesHL(){

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
			return 10;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "FactCashBalances.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.dimDate.getId());
			init.add(UtilityTransformations.dimBroker.getId());
			init.add(UtilityTransformations.taxRate.getId());
			init.add(UtilityTransformations.dimCustomer.getId());
			init.add(UtilityTransformations.dimAccount.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.factCashBalancesDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.factCashBalancesInput.getNullPercentage());
			parameters.add(DataUtilityETLs.factCashBalancesInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.factCashBalancesInput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.jobDimAccountOutput.getNullPercentage());
			parameters.add(DataUtilityETLs.jobDimAccountOutput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.jobDimAccountOutput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.jobDimDateOutput.getNullPercentage());
			parameters.add(DataUtilityETLs.jobDimDateOutput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.jobDimDateOutput.getId(), parameters);
			return dataUtils;
		}
	},

	factholdingsHL(){

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
			return 11;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "FactHoldings.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.factHoldingsDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			return dataUtils;
		}
	},

	industryHL(){

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
			return 12;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "Industry.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.industryDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.IndustryInput.getNullPercentage());
			parameters.add(DataUtilityETLs.IndustryInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.IndustryInput.getId(), parameters);
			return dataUtils;
		}
	},

	prospectHL(){

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
			return 13;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "Prospect.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.taxRate.getId());
			init.add(UtilityTransformations.dimCustomer.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.prospectDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.ProspectInput.getNullPercentage());
			parameters.add(DataUtilityETLs.ProspectInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.ProspectInput.getId(), parameters);
			parameters.clear();
			parameters.add(DataUtilityETLs.jobDimCustomerOutput.getNullPercentage());
			parameters.add(DataUtilityETLs.jobDimCustomerOutput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.jobDimCustomerOutput.getId(), parameters);
			return dataUtils;
		}
	},

	statustypeHL(){

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
			return 14;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "StatusType.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.statusTypeDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();		
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.StatusTypeInput.getNullPercentage());
			parameters.add(DataUtilityETLs.StatusTypeInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.StatusTypeInput.getId(), parameters);
			return dataUtils;
		}
	},

	taxrateHL(){

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
			return 15;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "TaxRate.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.taxRateDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.TaxRateInput.getNullPercentage());
			parameters.add(DataUtilityETLs.TaxRateInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.TaxRateInput.getId(), parameters);
			return null;
		}
	},

	tradetypeHL(){

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
			return 16;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "TradeType.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();			
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.tradeTypeDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			ArrayList<Double> parameters = new ArrayList<Double>();
			parameters.add(DataUtilityETLs.TradeTypeInput.getNullPercentage());
			parameters.add(DataUtilityETLs.TradeTypeInput.getScaleFactor());
			dataUtils.put(DataUtilityETLs.TradeTypeInput.getId(), parameters);
			return null;
		}
	},

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
			init.add(UtilityTransformations.dimDate.getId());
			init.add(UtilityTransformations.dimBroker.getId());
			init.add(UtilityTransformations.taxRate.getId());
			init.add(UtilityTransformations.dimCustomer.getId());
			init.add(UtilityTransformations.dimAccount.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.accountKeysDelete.getId());
			preInit.add(UtilityTransformations.dimAccountDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},
	dimAccountSurKeyHU(){

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
			return 18;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "UpdateDimAccountSurKey.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},
	dimAccountUpdateHU(){

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
			return 19;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "UpdateDimAccount.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},
	dimCustomerUpdateJobHU(){

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
			return 20;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "JobUpdateDimCustomer.kjb";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.taxRate.getId());
			init.add(UtilityTransformations.dimCustomer.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.customerKeysDelete.getId());
			preInit.add(UtilityTransformations.dimCustomerDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},
	dimCustomerSurKeyHU(){

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
			return 21;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "UpdateDimCustomerSurKey.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},
	dimCustomerUpdateHU(){

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
			return 22;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "UpdateDimCustomer.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	dimAccountUpdateJobIU(){

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
			return 23;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "JobIncUpdateDimAccount.kjb";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.dimAccount.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.accountKeysDelete.getId());
			preInit.add(UtilityTransformations.dimAccountDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	dimAccountSurKeyIU(){

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
			return 24;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "IncUpdateAccountSurKey.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	dimAccountUpdateIU(){

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
			return 25;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "IncUpdateDimAccount.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	dimCustomerUpdateJobIU(){

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
			return 26;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "JobIncUpdateDimCustomer.kjb";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.dimCustomer.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.customerKeysDelete.getId());
			preInit.add(UtilityTransformations.dimCustomerDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	dimCustomerSurKeyIU(){

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
			return 27;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "IncUpdateDimCustomerSurKey.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	dimCustomerUpdateIU(){

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
			return 28;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "IncUpdateDimCustomer.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},
	
	dimTradeUpdateJobHU(){
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
			return 33;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "JobIncDimTrade.kjb";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();			
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.dimTradeDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	dimTradeUpdatePhase1IU(){

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
			return 29;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "UpdateDimTradePh1.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	dimTradeUpdatePhase2IU(){

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
			return 30;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "UpdateDimTradePh1.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	factcashbalancesIU(){

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
			return 31;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "UpdateFactCashBalances.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			ArrayList<Integer> init = new ArrayList<Integer>();
			init.add(UtilityTransformations.dimDate.getId());
			init.add(UtilityTransformations.dimBroker.getId());
			init.add(UtilityTransformations.taxRate.getId());
			init.add(UtilityTransformations.dimCustomer.getId());
			init.add(UtilityTransformations.dimAccount.getId());
			init.add(UtilityTransformations.factCashBalances.getId());
			return init;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			preInit.add(UtilityTransformations.factCashBalancesDelete.getId());
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	},

	factholdingsIU(){

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
			return 32;
		}

		@Override
		public String getFileName() {
			// TODO Auto-generated method stub
			return "UpdateFactHoldings.ktr";
		}

		@Override
		public ArrayList<Integer> getInitUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Integer> getPreInitUtils() {
			ArrayList<Integer> preInit = new ArrayList<Integer>();
			return preInit;
		}

		@Override
		public ArrayList<Integer> getCompenUtils() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Map<Integer, ArrayList<Double>> getDataUtils() {
			Map<Integer, ArrayList<Double>> dataUtils = new HashMap<Integer, ArrayList<Double>>();
			// TODO Auto-generated method stub
			return null;
		}
	}
}