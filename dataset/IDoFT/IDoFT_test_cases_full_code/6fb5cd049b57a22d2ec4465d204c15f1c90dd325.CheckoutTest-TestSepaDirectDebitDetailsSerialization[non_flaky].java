@Test public void TestSepaDirectDebitDetailsSerialization() throws JsonProcessingException {
  String expectedJson="{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"iban\":\"DE87123456781234567890\",\"ownerName\":\"A. Schneider\",\"type\":\"sepadirectdebit\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
  SepaDirectDebitDetails sepaDirectDebitDetails=new SepaDirectDebitDetails();
  sepaDirectDebitDetails.setOwnerName("A. Schneider");
  sepaDirectDebitDetails.setIban("DE87123456781234567890");
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(sepaDirectDebitDetails);
  String gson=GSON.toJson(paymentsRequest);
  assertJsonStringEquals(expectedJson,gson);
  String jackson=OBJECT_MAPPER.writeValueAsString(paymentsRequest);
  assertJsonStringEquals(expectedJson,jackson);
}
