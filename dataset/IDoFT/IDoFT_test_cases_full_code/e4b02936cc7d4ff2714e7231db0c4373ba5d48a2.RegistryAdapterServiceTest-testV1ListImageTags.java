@Test public void testV1ListImageTags() throws Throwable {
  URI defaultRegistryStateUri=UriUtils.buildUri(host,defaultRegistryStateLink);
  sendRegistryListTagsRequest(defaultRegistryStateUri,"v1registry.test/vmware/admiral",(  Operation op) -> {
    String[] tags=op.getBody(String[].class);
    assertNotNull("result is null",tags);
    assertArrayEquals(new String[]{"7.1","7.2","7.3","7.4"},tags);
  }
);
}
