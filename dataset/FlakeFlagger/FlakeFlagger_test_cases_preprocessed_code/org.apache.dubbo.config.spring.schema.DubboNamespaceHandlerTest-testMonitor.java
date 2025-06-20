@Test public void testMonitor(){
assertThat(ctx.getBean(MonitorConfig.class),not(nullValue()));
}