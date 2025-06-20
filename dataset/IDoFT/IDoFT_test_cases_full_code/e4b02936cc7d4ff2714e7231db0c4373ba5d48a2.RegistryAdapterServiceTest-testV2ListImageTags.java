@Test public void testV2ListImageTags() throws Throwable {
  URI v2RegistryStateUri=UriUtils.buildUri(host,v2RegistryStateLink);
  sendRegistryListTagsRequest(v2RegistryStateUri,"v2registry.test/vmware/admiral",(  Operation op) -> {
    String[] tags=op.getBody(String[].class);
    assertNotNull("result is null",tags);
    assertArrayEquals(new String[]{"7.1","7.2","7.3","7.4"},tags);
  }
);
}
