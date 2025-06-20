@Test public void provideDisabledAutoDiscovery(){
assertThat(discovery).isNotNull().isExactlyInstanceOf(DisabledAutoDiscovery.class);
}