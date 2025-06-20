@Test public void testSkipExhausted(){
assertEquals(poolWith7Active,roundRobinBalancingPolicy.getPool(pools,new HashSet<CassandraHost>(Arrays.asList(new CassandraHost("127.0.0.1:9160")))));
assertEquals(poolWith10Active,roundRobinBalancingPolicy.getPool(pools,new HashSet<CassandraHost>(Arrays.asList(new CassandraHost("127.0.0.1:9160")))));
assertEquals(poolWith7Active,roundRobinBalancingPolicy.getPool(pools,new HashSet<CassandraHost>(Arrays.asList(new CassandraHost("127.0.0.1:9160")))));
assertEquals(poolWith10Active,roundRobinBalancingPolicy.getPool(pools,new HashSet<CassandraHost>(Arrays.asList(new CassandraHost("127.0.0.1:9160")))));
}