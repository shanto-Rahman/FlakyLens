@Test public void testDateColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}