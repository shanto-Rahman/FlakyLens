@Test public void Test3DSecureRequest(){
  PaymentRequest3d paymentRequest3d=create3DPaymentRequest();
  String paymentRequestJson=PRETTY_PRINT_GSON.toJson(paymentRequest3d);
  String expected="{\n" + "  \"md\": \"mdString\",\n" + "  \"paResponse\": \"paResString\",\n"+ "  \"shopperIP\": \"1.2.3.4\",\n"+ "  \"merchantAccount\": \"AMerchant\",\n"+ "  \"browserInfo\": {\n"+ "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n"+ "    \"acceptHeader\": \"*/*\"\n"+ "  },\n"+ "  \"applicationInfo\": {\n"+ "    \"adyenLibrary\": {\n"+ "      \"name\": \"" + LIB_NAME + "\",\n"+ "      \"version\": \""+ LIB_VERSION+ "\"\n"+ "    }\n"+ "  }\n"+ "}";
  assertJsonStringEquals(expected,paymentRequestJson);
}
