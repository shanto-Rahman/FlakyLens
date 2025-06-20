@Test public void testIPv6Column(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}