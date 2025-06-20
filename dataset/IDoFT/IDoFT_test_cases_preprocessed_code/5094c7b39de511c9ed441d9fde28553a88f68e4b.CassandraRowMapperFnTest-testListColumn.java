@Test public void testListColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}