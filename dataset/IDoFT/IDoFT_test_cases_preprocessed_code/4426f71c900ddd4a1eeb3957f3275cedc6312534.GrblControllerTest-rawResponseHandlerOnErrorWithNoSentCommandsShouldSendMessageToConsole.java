@Test public void rawResponseHandlerOnErrorWithNoSentCommandsShouldSendMessageToConsole() throws Exception {
assertFalse(instance.getActiveCommand().isPresent());
}