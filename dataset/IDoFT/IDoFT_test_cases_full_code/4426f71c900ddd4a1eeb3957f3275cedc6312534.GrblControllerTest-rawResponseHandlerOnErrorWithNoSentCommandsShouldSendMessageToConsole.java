@Test public void rawResponseHandlerOnErrorWithNoSentCommandsShouldSendMessageToConsole() throws Exception {
  GrblController instance=new GrblController(mgc);
  instance.setDistanceModeCode("G90");
  instance.setUnitsCode("G21");
  instance.openCommPort(getSettings().getConnectionDriver(),"foo",2400);
  MessageService messageService=mock(MessageService.class);
  instance.setMessageService(messageService);
  instance.rawResponseHandler("error:1");
  String genericErrorMessage="An unexpected error was detected: (error:1) G-code words consist of a letter and a value. Letter was not found.\n";
  verify(messageService,times(1)).dispatchMessage(MessageType.INFO,genericErrorMessage);
  verify(messageService,times(1)).dispatchMessage(any(),anyString());
  assertFalse(instance.getActiveCommand().isPresent());
}
