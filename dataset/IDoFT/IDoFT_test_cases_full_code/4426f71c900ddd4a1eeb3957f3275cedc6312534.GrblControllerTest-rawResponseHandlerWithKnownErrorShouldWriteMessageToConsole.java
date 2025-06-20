@Test public void rawResponseHandlerWithKnownErrorShouldWriteMessageToConsole() throws Exception {
  GrblController instance=new GrblController(mgc);
  instance.openCommPort(getSettings().getConnectionDriver(),"foo",2400);
  instance.commandSent(new GcodeCommand("G0"));
  MessageService messageService=mock(MessageService.class);
  instance.setMessageService(messageService);
  instance.rawResponseHandler("error:1");
  String genericErrorMessage="Error while processing response <error:1>\n";
  verify(messageService,times(0)).dispatchMessage(MessageType.ERROR,genericErrorMessage);
  String errorMessage="An error was detected while sending 'G0': (error:1) G-code words consist of a letter and a value. Letter was not found. Streaming has been paused.\n";
  verify(messageService).dispatchMessage(MessageType.ERROR,errorMessage);
  verify(messageService,times(1)).dispatchMessage(any(),anyString());
  assertFalse(instance.getActiveCommand().isPresent());
}
