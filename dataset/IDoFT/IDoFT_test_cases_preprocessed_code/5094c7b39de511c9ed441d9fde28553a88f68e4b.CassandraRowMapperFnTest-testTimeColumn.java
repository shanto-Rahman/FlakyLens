@Test public void testTimeColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}