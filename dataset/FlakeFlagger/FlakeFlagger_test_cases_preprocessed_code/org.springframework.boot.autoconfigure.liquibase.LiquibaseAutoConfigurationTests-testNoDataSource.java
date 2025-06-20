@Test public void testNoDataSource() throws Exception {
assertEquals(0,this.context.getBeanNamesForType(SpringLiquibase.class).length);
}