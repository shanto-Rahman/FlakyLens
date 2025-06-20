@Test public void TestGooglePayDetailsSerialization() throws JsonProcessingException {
  String expectedJson="{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"googlePayCardNetwork\":\"googlepaycardnetwork\",\"googlePayToken\":\"Payload as retrieved from Google Pay response\",\"type\":\"paywithgoogle\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
  GooglePayDetails googlePayDetails=new GooglePayDetails();
  googlePayDetails.setGooglePayToken("Payload as retrieved from Google Pay response");
  googlePayDetails.setFundingSource(GooglePayDetails.FundingSourceEnum.CREDIT);
  googlePayDetails.setGooglePayCardNetwork("googlepaycardnetwork");
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(googlePayDetails);
  String gson=GSON.toJson(paymentsRequest);
  assertJsonStringEquals(expectedJson,gson);
  String jackson=OBJECT_MAPPER.writeValueAsString(paymentsRequest);
  assertJsonStringEquals(expectedJson,jackson);
}
