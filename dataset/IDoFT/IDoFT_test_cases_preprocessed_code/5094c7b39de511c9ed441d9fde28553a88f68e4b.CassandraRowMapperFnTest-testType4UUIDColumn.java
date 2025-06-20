@Test public void testType4UUIDColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}