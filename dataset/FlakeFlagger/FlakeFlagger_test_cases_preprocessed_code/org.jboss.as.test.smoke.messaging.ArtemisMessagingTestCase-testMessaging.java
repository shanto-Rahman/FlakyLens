@Test public void testMessaging() throws Exception {
latch.countDown();
assertTrue(latch.await(1,SECONDS));
assertEquals(text,message.get().getStringProperty(BODY));
}