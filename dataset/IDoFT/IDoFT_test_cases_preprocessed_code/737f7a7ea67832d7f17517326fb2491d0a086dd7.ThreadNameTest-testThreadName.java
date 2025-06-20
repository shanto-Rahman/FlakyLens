@Test public void testThreadName() throws Exception {
Thread.sleep(1000L * 5L);
if (!serverHandler.isSuccess() || !clientHandler.isSuccess()) {//IT
Assert.fail();
}
}