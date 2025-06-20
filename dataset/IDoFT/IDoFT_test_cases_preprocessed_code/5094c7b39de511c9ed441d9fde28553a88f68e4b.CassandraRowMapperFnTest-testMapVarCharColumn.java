@Test public void testMapVarCharColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}