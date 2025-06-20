@Test public void testConfiguratorClockResolution(){
assertNotSame(CassandraHostConfigurator.DEF_CLOCK_RESOLUTION,cassandraHostConfigurator.getClockResolution());
}