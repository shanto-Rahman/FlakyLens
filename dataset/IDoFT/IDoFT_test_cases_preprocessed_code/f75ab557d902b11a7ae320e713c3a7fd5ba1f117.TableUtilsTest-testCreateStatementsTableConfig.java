@Test public void testCreateStatementsTableConfig() throws Exception {
assertEquals(1,stmts.size());
assertEquals(expectedCreateStatement(),stmts.get(0));
}