@Test public void testButtonSignatureWithJSONObject() throws Exception {
  final JSONObject payload=new JSONObject();
  payload.put("storeId","amzn1.application-oa2-client.xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  final JSONObject webCheckoutDetails=new JSONObject();
  webCheckoutDetails.put("checkoutReviewReturnUrl","https://localhost/test/CheckoutReview.php");
  webCheckoutDetails.put("checkoutResultReturnUrl","https://localhost/test/CheckoutResult.php");
  payload.put("webCheckoutDetails",webCheckoutDetails);
  final String signatureString=client.generateButtonSignature(payload);
  signature.update(PLAIN_TEXT.getBytes());
  Assert.assertTrue(signature.verify(Base64.decode(signatureString)));
}
