@Test public void definedManagementServerProperties() throws Exception {
assertThat(context.getBean(ManagementServerProperties.class).getPort(),equalTo(Integer.valueOf(123)));
}