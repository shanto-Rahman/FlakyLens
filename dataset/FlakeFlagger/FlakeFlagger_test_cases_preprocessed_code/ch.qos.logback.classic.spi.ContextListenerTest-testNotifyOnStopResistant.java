@Test public void testNotifyOnStopResistant(){
assertEquals(UpdateType.STOP,listener.updateType);
assertEquals(listener.context,context);
}