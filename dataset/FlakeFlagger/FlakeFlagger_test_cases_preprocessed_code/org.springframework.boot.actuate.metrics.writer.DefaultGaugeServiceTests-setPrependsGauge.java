@Test public void setPrependsGauge(){
assertEquals("gauge.foo",captor.getValue().getName());
assertEquals(2.3,captor.getValue().getValue());
}