@Test public void usesManuallyDefinedTransactionManagerBeanIfAvailable(){
assertThat(txManager,instanceOf(CustomJpaTransactionManager.class));
}