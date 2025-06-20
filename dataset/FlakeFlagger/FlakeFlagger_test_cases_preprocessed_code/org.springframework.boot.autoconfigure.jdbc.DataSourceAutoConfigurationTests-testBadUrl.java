@Test(expected=BeanCreationException.class) public void testBadUrl() throws Exception {
assertNotNull(this.context.getBean(DataSource.class));
}