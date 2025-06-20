@Test public void TestCCPaymentRequest(){
  String integratorName="TestIntegrator";
  PaymentRequest paymentRequest=createFullCardPaymentRequest();
  ExternalPlatform externalPlatform=new ExternalPlatform();
  externalPlatform.setIntegrator(integratorName);
  paymentRequest.getApplicationInfo().setExternalPlatform(externalPlatform);
  paymentRequest.setMetadata(new HashMap<>());
  paymentRequest.getMetadata().put("key","value");
  paymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.CARD_ON_FILE);
  String paymentRequestJson=PRETTY_PRINT_GSON.toJson(paymentRequest);
  String expected="{\n" + "  \"card\": {\n" + "    \"expiryMonth\": \"08\",\n"+ "    \"expiryYear\": \"2018\",\n"+ "    \"cvc\": \"737\",\n"+ "    \"holderName\": \"John Doe\",\n"+ "    \"number\": \"5136333333333335\"\n"+ "  },\n"+ "  \"recurringProcessingModel\": \"CardOnFile\",\n"+ "  \"amount\": {\n"+ "    \"value\": 100000,\n"+ "    \"currency\": \"EUR\"\n"+ "  },\n"+ "  \"reference\": \"123456\",\n"+ "  \"shopperIP\": \"1.2.3.4\",\n"+ "  \"merchantAccount\": \"AMerchant\",\n"+ "  \"browserInfo\": {\n"+ "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n"+ "    \"acceptHeader\": \"*/*\"\n"+ "  },\n"+ "  \"metadata\": {\n"+ "    \"key\": \"value\"\n"+ "  },\n"+ "  \"applicationInfo\": {\n"+ "    \"adyenLibrary\": {\n"+ "      \"name\": \"" + LIB_NAME + "\",\n"+ "      \"version\": \""+ LIB_VERSION+ "\"\n"+ "    },\n"+ "    \"externalPlatform\": {\n"+ "      \"integrator\": \""+ integratorName+ "\"\n"+ "    }\n"+ "  }\n"+ "}";
  assertJsonStringEquals(expected,paymentRequestJson);
}
