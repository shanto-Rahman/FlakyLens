@Test public void testNotifyOnReset(){
assertEquals(UpdateType.RESET,listener.updateType);
assertEquals(listener.context,context);
}