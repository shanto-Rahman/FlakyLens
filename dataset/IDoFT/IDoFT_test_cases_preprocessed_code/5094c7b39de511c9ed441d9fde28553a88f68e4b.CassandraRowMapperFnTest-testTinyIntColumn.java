@Test public void testTinyIntColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}