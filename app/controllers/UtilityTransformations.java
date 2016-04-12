package controllers;

public enum UtilityTransformations implements UtilityTransformation {
	
	accountKeysDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from accountkeys table";
		}

		@Override
		public int getId() {
			return 0;
		}		
	},
	dimAccountDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimaccount table";
		}

		@Override
		public int getId() {
			return 1;
		}		
	},
	customerKeysDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from customerkeys table";
		}

		@Override
		public int getId() {
			return 2;
		}		
	},
	dimCustomerDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimcustomer table";
		}

		@Override
		public int getId() {
			return 3;
		}		
	},
	brokerKeysDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from brokerkeys table";
		}

		@Override
		public int getId() {
			return 4;
		}		
	},
	dimBrokerDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimbroker table";
		}

		@Override
		public int getId() {
			return 5;
		}		
	},
	companyKeysDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from companykeys table";
		}

		@Override
		public int getId() {
			return 6;
		}		
	},
	dimCompanyDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimcompany table";
		}

		@Override
		public int getId() {
			return 7;
		}		
	},
	securityKeysDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from securitykeys table";
		}

		@Override
		public int getId() {
			return 8;
		}		
	},
	dimSecurityDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimsecurity table";
		}

		@Override
		public int getId() {
			return 9;
		}		
	},
	dimDateDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimdate table";
		}

		@Override
		public int getId() {
			return 10;
		}		
	},
	dimTimeDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimtime table";
		}

		@Override
		public int getId() {
			return 11;
		}		
	},
	dimTradeDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from dimtrade table";
		}

		@Override
		public int getId() {
			return 12;
		}		
	},
	factCashBalancesDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from factcashbalances table";
		}

		@Override
		public int getId() {
			return 13;
		}		
	},
	factHoldingsDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from factholdings table";
		}

		@Override
		public int getId() {
			return 14;
		}		
	},
	financialDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from financial table";
		}

		@Override
		public int getId() {
			return 15;
		}		
	},
	prospectDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from prospect table";
		}

		@Override
		public int getId() {
			return 16;
		}		
	},
	
	statusTypeDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from statustype table";
		}

		@Override
		public int getId() {
			return 17;
		}		
	},
	taxRateDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from taxrate table";
		}

		@Override
		public int getId() {
			return 18;
		}		
	},
	tradeTypeDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from tradetype table";
		}

		@Override
		public int getId() {
			return 19;
		}		
	},
	industryDelete(){

		@Override
		public String getDescription() {	
			return "Delete everything from industry table";
		}

		@Override
		public int getId() {
			return 20;
		}		
	},
	dimCustomer(){

		@Override
		public String getDescription() {	
			return "Populate dimcustomer and customerkeys tables";
		}

		@Override
		public int getId() {
			return 21;
		}		
	},
	dimAccount(){

		@Override
		public String getDescription() {	
			return "Populate dimaccount and accountkeys tables";
		}

		@Override
		public int getId() {
			return 22;
		}		
	},
	dimBroker(){

		@Override
		public String getDescription() {	
			return "Populate dimbroker and brokerkeys tables";
		}

		@Override
		public int getId() {
			return 23;
		}		
	},
	taxRate(){

		@Override
		public String getDescription() {	
			return "Populate taxrate table";
		}

		@Override
		public int getId() {
			return 24;
		}		
	},
	dimDate(){

		@Override
		public String getDescription() {	
			return "Populate dimDate table";
		}

		@Override
		public int getId() {
			return 25;
		}		
	},
	dimCompany(){

		@Override
		public String getDescription() {	
			return "Populate dimCompany table";
		}

		@Override
		public int getId() {
			return 26;
		}		
	},
	statusType(){

		@Override
		public String getDescription() {	
			return "Populate statustype table";
		}

		@Override
		public int getId() {
			return 27;
		}		
	},
	factCashBalances(){

		@Override
		public String getDescription() {	
			return "Populate statustype table";
		}

		@Override
		public int getId() {
			return 28;
		}		
	}				

}
