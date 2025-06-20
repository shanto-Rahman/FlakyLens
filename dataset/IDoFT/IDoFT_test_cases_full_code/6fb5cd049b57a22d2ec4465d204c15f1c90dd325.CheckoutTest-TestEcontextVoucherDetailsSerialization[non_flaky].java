@Test public void TestEcontextVoucherDetailsSerialization() throws JsonProcessingException {
  String expectedJson="{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"firstName\":\"John\",\"lastName\":\"Smith\",\"shopperEmail\":\"test@email.com\",\"telephoneNumber\":\"0123456789\",\"type\":\"econtext_seveneleven\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
  EcontextVoucherDetails econtextVoucherDetails=new EcontextVoucherDetails();
  econtextVoucherDetails.setFirstName("John");
  econtextVoucherDetails.setLastName("Smith");
  econtextVoucherDetails.setShopperEmail("test@email.com");
  econtextVoucherDetails.setTelephoneNumber("0123456789");
  econtextVoucherDetails.setType(EcontextVoucherDetails.SEVENELEVEN);
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(econtextVoucherDetails);
  String gson=GSON.toJson(paymentsRequest);
  assertJsonStringEquals(expectedJson,gson);
  String jackson=OBJECT_MAPPER.writeValueAsString(paymentsRequest);
  assertJsonStringEquals(expectedJson,jackson);
}
