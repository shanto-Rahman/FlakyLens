@Test public void findHost(){
assertSame(this.hostName,result.getName());
assertSame(this.engine,result.getEngine());
assertNull(this.engine.findHost("no-such-host"));
}