@Test public void rawResponseHandlerWithUnknownErrorShouldWriteGenericMessageToConsole() throws Exception {
  GrblController instance=new GrblController(mgc);
  instance.setDistanceModeCode("G90");
  instance.setUnitsCode("G21");
  instance.openCommPort(getSettings().getConnectionDriver(),"foo",2400);
  instance.commandSent(new GcodeCommand("G21"));
  MessageService messageService=mock(MessageService.class);
  instance.setMessageService(messageService);
  instance.rawResponseHandler("error:18");
  String genericErrorMessage="An error was detected while sending 'G21': (error:18) An unknown error has occurred. Streaming has been paused.\n";
  verify(messageService,times(1)).dispatchMessage(MessageType.ERROR,genericErrorMessage);
  verify(messageService,times(1)).dispatchMessage(any(),anyString());
  assertFalse(instance.getActiveCommand().isPresent());
}
