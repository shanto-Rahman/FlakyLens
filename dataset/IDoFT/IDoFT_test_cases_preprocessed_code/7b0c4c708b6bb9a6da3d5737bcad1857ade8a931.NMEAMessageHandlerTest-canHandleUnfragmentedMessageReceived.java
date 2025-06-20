@Test public void canHandleUnfragmentedMessageReceived(){
oneOf(aisMessageHandler).accept(with(aisMessage.getMatcher()));//RW
aisMessageReceiver.accept(unfragmentedNMEAMessage);//RW
assertEquals(AISMessageType.PositionReportClassAScheduled,aisMessage.getCapturedObject().getMessageType());
}