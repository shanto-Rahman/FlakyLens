@Test public void testTimestampColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}