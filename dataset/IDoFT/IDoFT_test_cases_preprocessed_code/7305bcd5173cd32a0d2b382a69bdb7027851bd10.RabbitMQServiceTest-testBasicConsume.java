@Test public void testBasicConsume(TestContext ctx) throws Exception {
ctx.assertNotNull(json);
ctx.assertNotNull(body);
ctx.assertTrue(messages.contains(body));
}