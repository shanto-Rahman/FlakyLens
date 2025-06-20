@Test public void TestVisaCheckoutDetailsSerialization() throws JsonProcessingException {
  String expectedJson="{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"fundingSource\":\"credit\",\"type\":\"visacheckout\",\"visaCheckoutCallId\":\"visacheckoutcallid\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
  VisaCheckoutDetails visaCheckoutDetails=new VisaCheckoutDetails();
  visaCheckoutDetails.setFundingSource(VisaCheckoutDetails.FundingSourceEnum.CREDIT);
  visaCheckoutDetails.setVisaCheckoutCallId("visacheckoutcallid");
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(visaCheckoutDetails);
  String gson=GSON.toJson(paymentsRequest);
  assertJsonStringEquals(expectedJson,gson);
  String jackson=OBJECT_MAPPER.writeValueAsString(paymentsRequest);
  assertJsonStringEquals(expectedJson,jackson);
}
