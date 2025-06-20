@Test public void testDefaultSpringLiquibase() throws Exception {
assertEquals("classpath:/db/changelog/db.changelog-master.yaml",liquibase.getChangeLog());
assertNull(liquibase.getContexts());
assertNull(liquibase.getDefaultSchema());
assertFalse(liquibase.isDropFirst());
}