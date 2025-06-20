@Test public void customPersistenceUnitManager() throws Exception {
assertThat(field.get(entityManagerFactoryBean),equalTo((Object)this.context.getBean(PersistenceUnitManager.class)));
}