@Test public void TestWeChatPayDetailsSerialization() throws JsonProcessingException {
  String expectedJson="{\"amount\":{\"value\":1000,\"currency\":\"USD\"},\"merchantAccount\":\"MagentoMerchantTest\",\"paymentMethod\":{\"appId\":\"appId\",\"openid\":\"openId\",\"type\":\"wechatpay\"},\"reference\":\"Your order number\",\"returnUrl\":\"https://your-company.com/...\",\"applicationInfo\":{\"adyenLibrary\":{\"name\":\"adyen-java-api-library\",\"version\":\"" + LIB_VERSION + "\"}}}";
  WeChatPayDetails weChatPayDetails=new WeChatPayDetails();
  weChatPayDetails.setAppId("appId");
  weChatPayDetails.setOpenid("openId");
  PaymentsRequest paymentsRequest=createPaymentsCheckoutRequest();
  paymentsRequest.setPaymentMethod(weChatPayDetails);
  String gson=GSON.toJson(paymentsRequest);
  assertJsonStringEquals(expectedJson,gson);
  String jackson=OBJECT_MAPPER.writeValueAsString(paymentsRequest);
  assertJsonStringEquals(expectedJson,jackson);
}
