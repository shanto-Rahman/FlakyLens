@Test public void testCustomNamingStrategyViaJpaProperties() throws Exception {
assertThat(actual,not(equalTo("org.hibernate.cfg.EJB3NamingStrategy")));
}