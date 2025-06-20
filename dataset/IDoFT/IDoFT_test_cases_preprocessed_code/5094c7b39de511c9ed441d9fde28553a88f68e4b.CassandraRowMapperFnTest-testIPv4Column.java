@Test public void testIPv4Column(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}