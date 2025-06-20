@Test(expected=BeanCreationException.class) public void testBadDriverClass() throws Exception {
assertNotNull(this.context.getBean(DataSource.class));
}