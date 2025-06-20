@Test public void testMessageLengthExceedPayloadLimitWhenEncode() throws Exception {
Assert.fail();
Assert.assertTrue(e.getMessage().startsWith("Data length too large: " + 6));
Assert.assertTrue(channel.getReceivedMessage() instanceof Response);
Assert.assertEquals(Response.BAD_RESPONSE,receiveMessage.getStatus());
Assert.assertTrue(receiveMessage.getErrorMessage().contains("Data length too large: "));
}