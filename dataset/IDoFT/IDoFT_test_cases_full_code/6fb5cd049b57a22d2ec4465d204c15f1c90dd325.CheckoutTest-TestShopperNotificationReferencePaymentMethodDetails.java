@Test public void TestShopperNotificationReferencePaymentMethodDetails(){
  DefaultPaymentMethodDetails defaultPaymentMethodDetails=new DefaultPaymentMethodDetails();
  defaultPaymentMethodDetails.setShopperNotificationReference("IA0F7500002462");
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(defaultPaymentMethodDetails);
  String jsonRequest=PRETTY_PRINT_GSON.toJson(paymentsRequest);
  assertJsonStringEquals("{\n" + "  \"amount\": {\n" + "    \"value\": 1000,\n"+ "    \"currency\": \"USD\"\n"+ "  },\n"+ "  \"merchantAccount\": \"MagentoMerchantTest\",\n"+ "  \"paymentMethod\": {\n"+ "    \"shopperNotificationReference\": \"IA0F7500002462\"\n"+ "  },\n"+ "  \"reference\": \"Your order number\",\n"+ "  \"returnUrl\": \"https://your-company.com/...\",\n"+ "  \"applicationInfo\": {\n"+ "    \"adyenLibrary\": {\n"+ "      \"name\": \"" + LIB_NAME + "\",\n"+ "      \"version\": \""+ LIB_VERSION+ "\"\n"+ "    }\n"+ "  }\n"+ "}",jsonRequest);
}
