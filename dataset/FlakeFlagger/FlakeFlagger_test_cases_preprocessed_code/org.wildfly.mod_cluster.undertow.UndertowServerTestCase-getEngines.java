@Test public void getEngines(){
assertTrue(engines.hasNext());
assertSame(this.connector,engine.getProxyConnector());
assertFalse(engines.hasNext());
}