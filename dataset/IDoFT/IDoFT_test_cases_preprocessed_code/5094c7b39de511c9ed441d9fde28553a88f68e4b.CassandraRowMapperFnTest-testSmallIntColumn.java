@Test public void testSmallIntColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}