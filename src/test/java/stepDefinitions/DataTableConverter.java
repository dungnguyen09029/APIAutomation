package stepDefinitions;

import io.cucumber.java.ParameterType;

// for cucumber step type register and data table
public class DataTableConverter {

    @ParameterType("(Continue|Back|Complete Process)")
    public String process(String process) {
        return process;
    }

//    @DataTableType
//    public PropertyAddress PropertyAddressEntry(Map<String, String> entry) {
//        PropertyAddress result = new PropertyAddress();
//        result.setStreet(entry.get("street"));
//        result.setZip(entry.get("zip"));
//        result.setHouseNumber(entry.get("houseNumber"));
//        result.setCity(entry.get("city"));
//        return result;
//    }
//
//    @DataTableType
//    public FinancialData FinancialDataEntry(Map<String, String> entry) {
//        FinancialData result = new FinancialData();
//        result.setPurchasePrice(entry.get("purchasePrice"));
//        result.setValueOfProperty(entry.get("valueOfProperty"));
//        result.setValueExistingMortgage(entry.get("valueExistingMortgage"));
//        result.setFreeEquity(entry.get("freeEquity"));
//        result.setLoan(entry.get("loan"));
//        result.setPensionFundFrom2ndPillar(entry.get("pensionFundFrom2ndPillar"));
//        result.setPensionFundFrom3rdPillar(entry.get("pensionFundFrom3rdPillar"));
//        result.setYearlyIncomeGross(entry.get("yearlyIncomeGross"));
//        result.setLiabilities(entry.get("liabilities"));
//        return result;
//    }
//
//    @DataTableType
//    public Person PersonEntry(Map<String, String> entry) {
//        Person result = new Person();
//        result.setSalutation(entry.get("salutation"));
//        result.setMaritalStatus(entry.get("maritalStatus"));
//        result.setCustomerFirstName(entry.get("customerFirstName"));
//        result.setCustomerName(entry.get("customerName"));
//        result.setDateOfBirth(entry.get("dateOfBirth"));
//        result.setEmail(entry.get("email"));
//        result.setMobilePhone(entry.get("mobilePhone"));
//        return result;
//    }
}
