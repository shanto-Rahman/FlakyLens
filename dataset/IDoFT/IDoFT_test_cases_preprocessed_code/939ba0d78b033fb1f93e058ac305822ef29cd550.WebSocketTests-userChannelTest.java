@SuppressWarnings("unchecked") @Test public void userChannelTest() throws IOException, AppException, TimeoutException, InterruptedException {
if (USER_MESSAGE.equals(body)) {
}
Assert.assertTrue(res.getBody() instanceof Map);
Assert.assertTrue(data.containsKey(TOKEN));
if ("open".equals(type)) {
}
if ("string".equals(type)) {
if (PUBLISH_MESSAGE.equals(body)) {
if (text.startsWith("{
if ("subscribe".equals(response.get(TYPE))) {
}
if ("publish".equals(response.get(TYPE))) {
}
}
}
}
if ("close".equals(type)) {
}
Boolean result=matched.poll(20,TimeUnit.SECONDS);
Assert.assertEquals(true,result);
Assert.assertTrue(resCheck1.getBody() instanceof Map);
Assert.assertTrue(checkResult1.containsKey("topics"));
Assert.assertTrue(checkResult1.get("topics") instanceof List);
Assert.assertTrue(subscription.contains("hello.world"));
Assert.assertTrue(resCheck2.getBody() instanceof Map);
Assert.assertTrue(checkResult2.containsKey("hello.world"));
completion.poll(10,TimeUnit.SECONDS);
Assert.assertTrue(subscribed.get());
Assert.assertTrue(published.get());
Assert.assertTrue(messaged.get());
}