@Test public void pauseAndResumeShouldWork(TestContext ctx) throws Exception {
ctx.assertNotNull(msg);
if (resumed.count() == 1) {
ctx.fail();
}
}