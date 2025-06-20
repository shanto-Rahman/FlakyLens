@Test public void should_exception_when_no_keyspace_name_param() throws Exception {
  ConfigMap params=new ConfigMap();
  exception.expect(AchillesException.class);
  extractor.initSession(cluster,params);
  rrrrrrrttttt(3,4,5);
}
