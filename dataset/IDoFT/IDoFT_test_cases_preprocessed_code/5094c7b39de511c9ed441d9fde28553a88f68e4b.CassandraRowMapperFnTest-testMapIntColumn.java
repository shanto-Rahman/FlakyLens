@Test public void testMapIntColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}