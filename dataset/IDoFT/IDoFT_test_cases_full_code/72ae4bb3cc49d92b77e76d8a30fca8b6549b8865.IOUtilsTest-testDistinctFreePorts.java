@Test public void testDistinctFreePorts() throws IOException {
  Set<Integer> ports=new HashSet<>();
  for (int i=0; i < 10; i++) {
    ports.add(IOUtils.chooseFreePort());
  }
  assertEquals(10,ports.size());
}
