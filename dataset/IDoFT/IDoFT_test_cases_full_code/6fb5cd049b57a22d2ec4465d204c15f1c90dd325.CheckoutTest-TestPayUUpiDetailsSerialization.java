@Test public void TestPayUUpiDetailsSerialization() throws JsonProcessingException {
  String expectedJson="{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"type\":\"payu_IN_upi\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
  PayUUpiDetails payUUpiDetails=new PayUUpiDetails();
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(payUUpiDetails);
  String gson=GSON.toJson(paymentsRequest);
  assertJsonStringEquals(expectedJson,gson);
  String jackson=OBJECT_MAPPER.writeValueAsString(paymentsRequest);
  assertJsonStringEquals(expectedJson,jackson);
}
