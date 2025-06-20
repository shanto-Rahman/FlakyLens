@Test public void shouldGenerateGroupMappingUsingCustomNamingStrategy() throws Exception {
final File groupNameMappingFile=new File(FileUtils.getTempDirectory(),"groupMapping-" + new Date().getTime());
groupNames.load(new FileInputStream(groupNameMappingFile));
Assert.assertEquals(CustomNamingStrategyWroManagerFactory.PREFIX + "g1.js",groupNames.get("g1.js"));
}