@Test public void testDockerHubListImageTags() throws Throwable {
  URI dockerHubRegistryStateUri=UriUtils.buildUri(host,dockerHubRegistryStateLink);
  sendRegistryListTagsRequest(dockerHubRegistryStateUri,"vmware/admiral",(  Operation op) -> {
    String[] tags=op.getBody(String[].class);
    assertNotNull("result is null",tags);
    assertArrayEquals(new String[]{"7.1","7.2","7.3","7.4"},tags);
  }
);
}
