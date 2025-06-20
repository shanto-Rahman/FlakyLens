@Test public void updatePredefinedMeter(){
assertEquals(3,this.registry.meter("meter.foo").getCount());
}