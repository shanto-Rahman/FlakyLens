@Test public void setAndGet(){
assertEquals("foo",metric.getName());
assertEquals(12.3,metric.getValue().doubleValue(),0.01);
}