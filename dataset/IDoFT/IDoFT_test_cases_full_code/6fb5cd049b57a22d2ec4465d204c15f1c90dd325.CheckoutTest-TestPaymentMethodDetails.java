@Test public void TestPaymentMethodDetails(){
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  String jsonRequest=PRETTY_PRINT_GSON.toJson(paymentsRequest);
  assertJsonStringEquals("{\n" + "  \"amount\": {\n" + "    \"value\": 1000,\n"+ "    \"currency\": \"USD\"\n"+ "  },\n"+ "  \"merchantAccount\": \"MagentoMerchantTest\",\n"+ "  \"paymentMethod\": {\n"+ "    \"type\": \"scheme\",\n"+ "    \"number\": \"4111111111111111\",\n"+ "    \"expiryMonth\": \"10\",\n"+ "    \"expiryYear\": \"2018\",\n"+ "    \"holderName\": \"John Smith\",\n"+ "    \"cvc\": \"737\"\n"+ "  },\n"+ "  \"reference\": \"Your order number\",\n"+ "  \"returnUrl\": \"https://your-company.com/...\",\n"+ "  \"applicationInfo\": {\n"+ "    \"adyenLibrary\": {\n"+ "      \"name\": \"" + LIB_NAME + "\",\n"+ "      \"version\": \""+ LIB_VERSION+ "\"\n"+ "    }\n"+ "  }\n"+ "}",jsonRequest);
  TestPaymentMethodDetails testPaymentMethodDetails=new TestPaymentMethodDetails();
  testPaymentMethodDetails.setType("testType");
  testPaymentMethodDetails.setTestValue("testValue");
  paymentsRequest.setPaymentMethod(testPaymentMethodDetails);
  jsonRequest=PRETTY_PRINT_GSON.toJson(paymentsRequest);
  assertJsonStringEquals("{\n" + "  \"amount\": {\n" + "    \"value\": 1000,\n"+ "    \"currency\": \"USD\"\n"+ "  },\n"+ "  \"merchantAccount\": \"MagentoMerchantTest\",\n"+ "  \"paymentMethod\": {\n"+ "    \"testKey\": \"testValue\",\n"+ "    \"type\": \"testType\"\n"+ "  },\n"+ "  \"reference\": \"Your order number\",\n"+ "  \"returnUrl\": \"https://your-company.com/...\",\n"+ "  \"applicationInfo\": {\n"+ "    \"adyenLibrary\": {\n"+ "      \"name\": \"" + LIB_NAME + "\",\n"+ "      \"version\": \""+ LIB_VERSION+ "\"\n"+ "    }\n"+ "  }\n"+ "}",jsonRequest);
}
