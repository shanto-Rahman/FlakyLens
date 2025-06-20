@Test public void testNoDispatchEventForDisabledLevel() throws Exception {
assertTrue(receiver.awaitConnectorCreated(DELAY));//IT
assertNull(appender.awaitAppend(DELAY));
}