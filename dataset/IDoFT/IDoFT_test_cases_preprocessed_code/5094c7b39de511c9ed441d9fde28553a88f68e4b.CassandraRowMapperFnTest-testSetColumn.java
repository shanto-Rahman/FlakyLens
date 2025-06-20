@Test public void testSetColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}