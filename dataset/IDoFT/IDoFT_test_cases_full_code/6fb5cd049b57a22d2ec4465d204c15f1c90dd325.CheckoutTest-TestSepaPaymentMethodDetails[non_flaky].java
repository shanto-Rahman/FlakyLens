@Test public void TestSepaPaymentMethodDetails(){
  DefaultPaymentMethodDetails defaultPaymentMethodDetails=new DefaultPaymentMethodDetails();
  defaultPaymentMethodDetails.type("sepadirectdebit");
  defaultPaymentMethodDetails.setSepaOwnerName("A. Schneider");
  defaultPaymentMethodDetails.setSepaIbanNumber("DE87123456781234567890");
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(defaultPaymentMethodDetails);
  String jsonRequest=PRETTY_PRINT_GSON.toJson(paymentsRequest);
  assertJsonStringEquals("{\n" + "  \"amount\": {\n" + "    \"value\": 1000,\n"+ "    \"currency\": \"USD\"\n"+ "  },\n"+ "  \"merchantAccount\": \"MagentoMerchantTest\",\n"+ "  \"paymentMethod\": {\n"+ "    \"type\": \"sepadirectdebit\",\n"+ "    \"sepa.ownerName\": \"A. Schneider\",\n"+ "    \"sepa.ibanNumber\": \"DE87123456781234567890\"\n"+ "  },\n"+ "  \"reference\": \"Your order number\",\n"+ "  \"returnUrl\": \"https://your-company.com/...\",\n"+ "  \"applicationInfo\": {\n"+ "    \"adyenLibrary\": {\n"+ "      \"name\": \"" + LIB_NAME + "\",\n"+ "      \"version\": \""+ LIB_VERSION+ "\"\n"+ "    }\n"+ "  }\n"+ "}",jsonRequest);
}
