@Test public void testBasicCancel(TestContext ctx) throws Exception {
ctx.assertFalse(receivedTotal > count);
if (receivedTotal == 3) {
}
}