@Test public void portPropertiesOnSamePort() throws Exception {
assertThat(localServerPort,notNullValue());
assertThat(localManagementPort,notNullValue());
assertThat(localServerPort,equalTo(localManagementPort));
}