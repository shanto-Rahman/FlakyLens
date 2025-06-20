@Test public void TestDokuDetailsSerialization() throws JsonProcessingException {
  String expectedJson="{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"firstName\":\"John\",\"infix\":\"infix\",\"lastName\":\"Smith\",\"ovoId\":\"ovoid\",\"shopperEmail\":\"test@email.com\",\"type\":\"doku_indomaret\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
  DokuDetails dokuDetails=new DokuDetails();
  dokuDetails.setFirstName("John");
  dokuDetails.setInfix("infix");
  dokuDetails.setLastName("Smith");
  dokuDetails.setOvoId("ovoid");
  dokuDetails.setShopperEmail("test@email.com");
  dokuDetails.setType(DokuDetails.INDOMARET);
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(dokuDetails);
  String gson=GSON.toJson(paymentsRequest);
  assertJsonStringEquals(expectedJson,gson);
  String jackson=OBJECT_MAPPER.writeValueAsString(paymentsRequest);
  assertJsonStringEquals(expectedJson,jackson);
}
