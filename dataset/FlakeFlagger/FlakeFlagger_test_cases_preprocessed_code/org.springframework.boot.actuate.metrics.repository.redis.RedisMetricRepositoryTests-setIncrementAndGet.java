@Test public void setIncrementAndGet(){
assertEquals("foo",metric.getName());
assertEquals(15.3,metric.getValue().doubleValue(),0.01);
}