@Test public void provideAutoDiscovery(){
assertThat(discovery).isNotNull().isExactlyInstanceOf(AutoDiscovery.class);
}