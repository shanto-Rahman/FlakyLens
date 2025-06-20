@Test public void testJdbcTemplateExistsWithCustomDataSource() throws Exception {
assertNotNull(jdbcTemplate);
assertTrue(jdbcTemplate.getDataSource() instanceof BasicDataSource);
}