@Test public void doesNotEarlyInitializeFactoryBeans() throws Exception {
assertThat(bean,equalTo("bucket"));
}