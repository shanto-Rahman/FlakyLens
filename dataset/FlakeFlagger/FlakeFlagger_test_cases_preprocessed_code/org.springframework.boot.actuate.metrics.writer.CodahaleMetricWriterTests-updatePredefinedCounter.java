@Test public void updatePredefinedCounter(){
assertEquals(3,this.registry.counter("counter.foo").getCount());
}