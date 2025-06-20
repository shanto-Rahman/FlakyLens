@Test public void nativeConnectionFactoryIfEmbeddedServiceDisabledExplicitly(){
assertEquals(0,this.context.getBeansOfType(EmbeddedJMS.class).size());
}