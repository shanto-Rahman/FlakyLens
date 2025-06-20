@Test public void shouldBuildConfigurationEvenWhenDefaultPropertiesFileIsNotAvailable(){
Assert.assertNotNull(factory.create());
}