@Test public void getConnectors(){
assertTrue(results.hasNext());
assertSame(listenerName,connector.toString());
assertFalse(results.hasNext());
}