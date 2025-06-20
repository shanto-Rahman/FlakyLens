@Test public void testConfigValuesPropogated(){
assertEquals(20,cassandraHosts[1].getMaxActive());
assertEquals(20,cassandraHosts[0].getMaxActive());
assertEquals(5,cassandraHosts[1].getMaxIdle());
assertEquals(ExhaustedPolicy.WHEN_EXHAUSTED_GROW,cassandraHosts[1].getExhaustedPolicy());
assertEquals(4000,cassandraHosts[1].getMaxWaitTimeWhenExhausted());
assertEquals(3000,cassandraHosts[2].getCassandraThriftSocketTimeout());
assertEquals(3000,cassandraHosts[0].getCassandraThriftSocketTimeout());
}