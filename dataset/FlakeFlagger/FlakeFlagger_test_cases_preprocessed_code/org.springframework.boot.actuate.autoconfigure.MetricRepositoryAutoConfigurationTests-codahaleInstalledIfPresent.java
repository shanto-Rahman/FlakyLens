@Test public void codahaleInstalledIfPresent(){
assertNotNull(gaugeService);
assertEquals(new Double(2.7),gauge.getValue());
}