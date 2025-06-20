@Test public void keepMostRecentOptionShouldWorks(TestContext ctx) throws Exception {
ctx.assertTrue(msg.body().toString().equals(secondMessage),"only second message should be stored");
}