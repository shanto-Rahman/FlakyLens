@Test public void testRepository(){
  this.jdbcTemplate.update("INSERT INTO EXAMPLE_ENTITY (id, name, reference) VALUES (1, 'a', 'alpha')");
  this.jdbcTemplate.update("INSERT INTO EXAMPLE_ENTITY (id, name, reference) VALUES (2, 'b', 'bravo')");
  assertThat(this.repository.findAll()).hasSize(2);
}
