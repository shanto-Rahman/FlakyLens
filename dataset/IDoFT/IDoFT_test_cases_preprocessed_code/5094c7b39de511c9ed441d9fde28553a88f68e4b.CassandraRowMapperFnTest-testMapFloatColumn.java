@Test public void testMapFloatColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}