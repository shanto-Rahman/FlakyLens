@Test public void portPropertiesOnDifferentPort() throws Exception {
assertThat(localServerPort,notNullValue());
assertThat(localManagementPort,notNullValue());
assertThat(localServerPort,not(equalTo(localManagementPort)));
assertThat(this.applicationContext.getBean(ServerPortConfig.class).getCount(),equalTo(2));
}