private static void testStandalone(Class<? extends Command> clazz) throws Exception {
  Command c=clazz.newInstance();
  String synopsis=getStandaloneSynopsis(c);
  Assert.assertEquals(clazz.getName() + ". EXPECTED [" + ((TestCommand)c).getSynopsis()+ "]. FOUND ["+ synopsis+ "]",((TestCommand)c).getSynopsis(),synopsis);
}
