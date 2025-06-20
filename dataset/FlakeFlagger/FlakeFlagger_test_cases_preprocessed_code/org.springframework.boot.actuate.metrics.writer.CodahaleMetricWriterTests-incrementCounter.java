@Test public void incrementCounter(){
assertEquals(3,this.registry.counter("foo").getCount());
}