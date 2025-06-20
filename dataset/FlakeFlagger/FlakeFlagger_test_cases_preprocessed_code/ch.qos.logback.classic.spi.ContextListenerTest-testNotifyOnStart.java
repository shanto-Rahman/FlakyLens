@Test public void testNotifyOnStart(){
assertEquals(UpdateType.START,listener.updateType);
assertEquals(listener.context,context);
}