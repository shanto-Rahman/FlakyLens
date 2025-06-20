@Test public void TestCSEPaymentRequest(){
  PaymentRequest paymentRequest=createCSEPaymentRequest();
  String paymentRequestJson=PRETTY_PRINT_GSON.toJson(paymentRequest);
  String expected="{\n" + "  \"amount\": {\n" + "    \"value\": 100000,\n"+ "    \"currency\": \"EUR\"\n"+ "  },\n"+ "  \"reference\": \"123456\",\n"+ "  \"shopperIP\": \"1.2.3.4\",\n"+ "  \"merchantAccount\": \"AMerchant\",\n"+ "  \"browserInfo\": {\n"+ "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n"+ "    \"acceptHeader\": \"*/*\"\n"+ "  },\n"+ "  \"additionalData\": {\n"+ "    \"card.encrypted.json\": \"adyenjs_0_1_4p1$...\"\n"+ "  },\n"+ "  \"applicationInfo\": {\n"+ "    \"adyenLibrary\": {\n"+ "      \"name\": \"" + LIB_NAME + "\",\n"+ "      \"version\": \""+ LIB_VERSION+ "\"\n"+ "    }\n"+ "  }\n"+ "}";
  assertJsonStringEquals(expected,paymentRequestJson);
}
