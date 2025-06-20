@Test public void configurationPropertiesWithFactoryBean() throws Exception {
ConfigurationPropertiesWithFactoryBean.factoryBeanInit=false;//RW
assertFalse("Init too early",ConfigurationPropertiesWithFactoryBean.factoryBeanInit);//RW
assertTrue("No init",ConfigurationPropertiesWithFactoryBean.factoryBeanInit);//RW
}