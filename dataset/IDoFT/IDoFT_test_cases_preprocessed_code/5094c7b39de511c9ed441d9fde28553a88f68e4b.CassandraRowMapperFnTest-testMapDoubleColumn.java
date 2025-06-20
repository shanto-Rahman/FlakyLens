@Test public void testMapDoubleColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}