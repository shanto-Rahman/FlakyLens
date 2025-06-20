@Test public void embeddedConnectionFactoryByDefault(){
assertEquals(1,this.context.getBeansOfType(EmbeddedJMS.class).size());
assertFalse("Persistence disabled by default",configuration.isPersistenceEnabled());
assertFalse("Security disabled by default",configuration.isSecurityEnabled());
}