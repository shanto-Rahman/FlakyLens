@Test public void canHandleFragmentedMessageReceived(){
oneOf(aisMessageHandler).accept(with(aisMessage.getMatcher()));//RW
aisMessageReceiver.accept(fragmentedNMEAMessage1);//RW
aisMessageReceiver.accept(fragmentedNMEAMessage2);//RW
assertEquals(AISMessageType.ShipAndVoyageRelatedData,aisMessage.getCapturedObject().getMessageType());
}