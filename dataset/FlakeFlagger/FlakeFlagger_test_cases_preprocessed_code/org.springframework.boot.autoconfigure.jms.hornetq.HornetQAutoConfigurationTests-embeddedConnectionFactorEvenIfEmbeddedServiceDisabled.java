@Test public void embeddedConnectionFactorEvenIfEmbeddedServiceDisabled(){
assertEquals(0,this.context.getBeansOfType(EmbeddedJMS.class).size());
}