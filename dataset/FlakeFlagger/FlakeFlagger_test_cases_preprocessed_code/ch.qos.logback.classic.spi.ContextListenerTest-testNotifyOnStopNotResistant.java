@Test public void testNotifyOnStopNotResistant(){
assertEquals(UpdateType.RESET,listener.updateType);
assertEquals(listener.context,context);
}