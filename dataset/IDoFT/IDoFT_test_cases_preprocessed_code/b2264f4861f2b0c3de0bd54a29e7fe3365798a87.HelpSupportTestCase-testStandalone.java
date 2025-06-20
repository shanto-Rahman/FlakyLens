private static void testStandalone(Class<? extends Command> clazz) throws Exception {
Assert.assertEquals(clazz.getName() + ". EXPECTED [" + ((TestCommand)c).getSynopsis()+ "]. FOUND ["+ synopsis+ "]",((TestCommand)c).getSynopsis(),synopsis);
}