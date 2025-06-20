@Test public void placeholderResolutionWithCustomLocation() throws Exception {
assertThat(this.context.getBean(CustomConfigurationLocation.class).getFoo(),equalTo("bar"));
}