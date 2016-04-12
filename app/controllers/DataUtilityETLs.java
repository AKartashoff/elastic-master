package controllers;

public enum DataUtilityETLs implements DataUtilityETL{

	dimAccountInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	dimBrokerInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	dimCompanyInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	dimDateInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 3;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	dimSecurityInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	dimTimeInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 5;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	factCashBalancesInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 6;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	FinancialInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 7;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	IndustryInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 8;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobDimAccountOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 9;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobDimBrokerOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 10;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobDimCompanyOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 11;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobDimCustomerOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 12;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobDimDateOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 13;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobDimSecurityOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 14;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobDimTimeOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 15;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobFactCashBalancesOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 16;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobStatusTypeOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 17;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobTaxRateOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 18;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	jobTradeTypeOutput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 19;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	ProspectInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 20;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	StatusTypeInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 21;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0.2;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	TaxRateInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 22;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	},

	TradeTypeInput(){

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int getId() {
			// TODO Auto-generated method stub
			return 23;
		}

		@Override
		public double getNullPercentage() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public double getScaleFactor() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
}
