@Test public void test_received_request_event_readonly() throws RemotingException {
Assert.assertTrue(mchannel.hasAttribute(Constants.CHANNEL_ATTRIBUTE_READONLY_KEY));
}