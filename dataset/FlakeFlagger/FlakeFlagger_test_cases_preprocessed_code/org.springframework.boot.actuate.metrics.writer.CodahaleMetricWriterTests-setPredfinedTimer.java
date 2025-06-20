@Test public void setPredfinedTimer(){
assertEquals(2,this.registry.timer("timer.foo").getCount());
}