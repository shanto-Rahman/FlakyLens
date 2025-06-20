@Test public void rawResponseHandlerWithUnknownErrorShouldWriteGenericMessageToConsole() throws Exception {
assertFalse(instance.getActiveCommand().isPresent());
}