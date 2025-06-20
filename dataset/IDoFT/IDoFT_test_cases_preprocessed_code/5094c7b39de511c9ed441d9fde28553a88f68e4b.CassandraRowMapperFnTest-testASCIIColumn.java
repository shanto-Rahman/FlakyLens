@Test public void testASCIIColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}