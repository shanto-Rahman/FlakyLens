@Test public void shouldGenerateGroupMappingUsingNoOpNamingStrategy() throws Exception {
final File groupNameMappingFile=new File(FileUtils.getTempDirectory(),"groupMapping-" + new Date().getTime());
groupNames.load(new FileInputStream(groupNameMappingFile));
assertEquals("g1.js",groupNames.get("g1.js"));
}