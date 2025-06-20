@Test public void testMapBigIntColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}