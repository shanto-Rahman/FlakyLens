@Test public void TestGenericIssuerPaymentMethodDetails(){
  GenericIssuerPaymentMethodDetails genericIssuerPaymentMethodDetails=new GenericIssuerPaymentMethodDetails();
  genericIssuerPaymentMethodDetails.setIssuer("111");
  genericIssuerPaymentMethodDetails.setType("ideal");
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(genericIssuerPaymentMethodDetails);
  String jsonRequest=PRETTY_PRINT_GSON.toJson(paymentsRequest);
  assertJsonStringEquals("{\n" + "  \"amount\": {\n" + "    \"value\": 1000,\n"+ "    \"currency\": \"USD\"\n"+ "  },\n"+ "  \"merchantAccount\": \"MagentoMerchantTest\",\n"+ "  \"paymentMethod\": {\n"+ "    \"issuer\": \"111\",\n"+ "    \"type\": \"ideal\"\n"+ "  },\n"+ "  \"reference\": \"Your order number\",\n"+ "  \"returnUrl\": \"https://your-company.com/...\",\n"+ "  \"applicationInfo\": {\n"+ "    \"adyenLibrary\": {\n"+ "      \"name\": \"" + LIB_NAME + "\",\n"+ "      \"version\": \""+ LIB_VERSION+ "\"\n"+ "    }\n"+ "  }\n"+ "}",jsonRequest);
}
