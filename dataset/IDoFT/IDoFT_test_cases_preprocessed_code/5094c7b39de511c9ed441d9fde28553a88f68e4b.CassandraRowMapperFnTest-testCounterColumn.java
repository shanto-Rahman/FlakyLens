@Test public void testCounterColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}