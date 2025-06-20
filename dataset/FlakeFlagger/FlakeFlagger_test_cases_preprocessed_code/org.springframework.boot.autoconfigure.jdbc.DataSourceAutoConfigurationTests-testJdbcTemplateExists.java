@Test public void testJdbcTemplateExists() throws Exception {
assertNotNull(jdbcTemplate);
assertNotNull(jdbcTemplate.getDataSource());
}