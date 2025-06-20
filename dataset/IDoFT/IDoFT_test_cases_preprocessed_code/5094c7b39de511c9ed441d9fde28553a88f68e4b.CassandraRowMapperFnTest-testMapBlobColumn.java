@Test public void testMapBlobColumn(){
assertEquals(expected,cassandraRowMapper.map(resultSet).next());
}