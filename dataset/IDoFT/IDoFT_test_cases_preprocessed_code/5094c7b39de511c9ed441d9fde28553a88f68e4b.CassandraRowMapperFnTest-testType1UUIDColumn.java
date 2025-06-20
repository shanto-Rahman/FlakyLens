@Test public void testType1UUIDColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}