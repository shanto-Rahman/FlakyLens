@Test public void testNamingStrategyThatWorkedInOneDotOhContinuesToWork(){
assertThat(actual,equalTo("org.hibernate.cfg.EJB3NamingStrategy"));
}