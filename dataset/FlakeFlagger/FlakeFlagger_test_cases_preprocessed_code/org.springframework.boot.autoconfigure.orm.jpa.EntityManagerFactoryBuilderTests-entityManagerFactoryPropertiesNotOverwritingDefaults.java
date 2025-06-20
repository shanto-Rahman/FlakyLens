@Test public void entityManagerFactoryPropertiesNotOverwritingDefaults(){
assertFalse(result1.getJpaPropertyMap().isEmpty());
assertTrue(this.properties.getProperties().isEmpty());
}