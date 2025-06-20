@Test public void testMapBooleanColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}