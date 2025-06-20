@Test public void testVarIntColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}