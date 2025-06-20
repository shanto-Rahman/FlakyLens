@Test public void testMapColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}