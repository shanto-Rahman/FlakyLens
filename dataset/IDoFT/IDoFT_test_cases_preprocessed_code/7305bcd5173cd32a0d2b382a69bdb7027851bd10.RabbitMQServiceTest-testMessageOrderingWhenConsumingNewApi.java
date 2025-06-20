@Test public void testMessageOrderingWhenConsumingNewApi(TestContext ctx) throws IOException {
ctx.assertNotNull(ok.getQueue());
if (consumerHandler.succeeded()) {
ctx.assertNotNull(msg);
ctx.assertNotNull(body);
ctx.fail();
}
ctx.assertTrue(sendingOrder.get(i).equals(receivedOrder.get(i)));
}