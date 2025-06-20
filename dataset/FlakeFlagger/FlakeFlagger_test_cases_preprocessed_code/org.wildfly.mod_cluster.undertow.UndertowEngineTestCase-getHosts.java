@Test public void getHosts(){
assertTrue(results.hasNext());
assertSame(this.hostName,host.getName());
assertSame(this.engine,host.getEngine());
assertFalse(results.hasNext());
}