@Test public void dataSourceHealthIndicatorWithCustomValidationQuery(){
assertEquals(1,beans.size());
assertEquals(DataSourceHealthIndicator.class,healthIndicator.getClass());
assertEquals("SELECT from FOOBAR",dataSourceHealthIndicator.getQuery());
}