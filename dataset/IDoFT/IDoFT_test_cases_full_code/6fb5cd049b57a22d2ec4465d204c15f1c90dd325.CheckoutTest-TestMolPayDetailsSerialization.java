@Test public void TestMolPayDetailsSerialization() throws JsonProcessingException {
  String expectedJson="{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"issuer\":\"issuer\",\"type\":\"molpay_ebanking_direct_MY\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
  MolPayDetails molPayDetails=new MolPayDetails();
  molPayDetails.setIssuer("issuer");
  molPayDetails.setType(MolPayDetails.EBANKING_DIRECT_MY);
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(molPayDetails);
  String gson=GSON.toJson(paymentsRequest);
  assertJsonStringEquals(expectedJson,gson);
  String jackson=OBJECT_MAPPER.writeValueAsString(paymentsRequest);
  assertJsonStringEquals(expectedJson,jackson);
}
