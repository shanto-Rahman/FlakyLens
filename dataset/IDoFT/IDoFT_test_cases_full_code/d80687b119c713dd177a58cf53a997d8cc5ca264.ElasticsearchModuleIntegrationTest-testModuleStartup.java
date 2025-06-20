@Test public void testModuleStartup() throws IOException {
  String[] indices=client.getClient().admin().indices().prepareGetIndex().get().indices();
  log.info("indices in the cluster: ");
  for (  String index : indices) {
    log.info(index);
  }
}
