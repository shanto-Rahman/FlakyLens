@Test public void TestMbwayDetailsSerialization() throws JsonProcessingException {
  String expectedJson="{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"shopperEmail\":\"test@test.com\",\"telephoneNumber\":\"telephone\",\"type\":\"mbway\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
  MbwayDetails mbwayDetails=new MbwayDetails();
  mbwayDetails.setTelephoneNumber("telephone");
  mbwayDetails.setShopperEmail("test@test.com");
  mbwayDetails.setType(MbwayDetails.MBWAY);
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(mbwayDetails);
  String gson=GSON.toJson(paymentsRequest);
  assertJsonStringEquals(expectedJson,gson);
  String jackson=OBJECT_MAPPER.writeValueAsString(paymentsRequest);
  assertJsonStringEquals(expectedJson,jackson);
}
