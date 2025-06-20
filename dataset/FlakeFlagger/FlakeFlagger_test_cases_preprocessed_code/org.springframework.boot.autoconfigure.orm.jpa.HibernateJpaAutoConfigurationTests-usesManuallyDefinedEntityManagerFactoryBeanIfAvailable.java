@Test public void usesManuallyDefinedEntityManagerFactoryBeanIfAvailable(){
assertThat(map.get("configured"),equalTo((Object)"manually"));
}