@Test public void dataSourceHealthIndicator(){
assertEquals(1,beans.size());
assertEquals(DataSourceHealthIndicator.class,beans.values().iterator().next().getClass());
}