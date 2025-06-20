@Test(expected=BeanCreationException.class) public void testDataScript() throws Exception {
assertEquals(new Integer(1),new JdbcTemplate(this.context.getBean(DataSource.class)).queryForObject("SELECT COUNT(*) from CITY",Integer.class));
}