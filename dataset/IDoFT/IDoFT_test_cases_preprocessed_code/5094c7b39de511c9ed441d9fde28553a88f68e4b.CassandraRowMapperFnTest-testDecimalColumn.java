@Test public void testDecimalColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}