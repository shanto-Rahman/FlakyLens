public void testNoDbConnection(){
fail("expected exception");
assertTrue(containsSqlException(e));
}