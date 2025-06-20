@Test public void placeholderResolutionWithUnmergedCustomLocation() throws Exception {
assertThat(this.context.getBean(UnmergedCustomConfigurationLocation.class).getFoo(),equalTo("${fooValue}"));
}