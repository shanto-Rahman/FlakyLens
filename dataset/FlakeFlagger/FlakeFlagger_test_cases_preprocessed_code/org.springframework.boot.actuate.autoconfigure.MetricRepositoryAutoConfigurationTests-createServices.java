@Test public void createServices() throws Exception {
assertNotNull(gaugeService);
assertNotNull(context.getBean(DefaultCounterService.class));
assertEquals(2.7,context.getBean(MetricReader.class).findOne("gauge.foo").getValue());
}