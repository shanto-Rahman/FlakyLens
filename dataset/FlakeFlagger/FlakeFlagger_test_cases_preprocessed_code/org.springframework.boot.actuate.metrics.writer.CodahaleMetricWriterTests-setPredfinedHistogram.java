@Test public void setPredfinedHistogram(){
assertEquals(2,this.registry.histogram("histogram.foo").getCount());
}