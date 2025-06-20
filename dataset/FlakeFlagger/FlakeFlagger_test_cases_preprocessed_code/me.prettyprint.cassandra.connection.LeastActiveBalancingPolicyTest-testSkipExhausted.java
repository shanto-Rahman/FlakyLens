@Test public void testSkipExhausted(){
assertEquals(poolWith7Active,leastActiveBalancingPolicy.getPool(pools,new HashSet<CassandraHost>(Arrays.asList(new CassandraHost("127.0.0.1:9160")))));
}