@Test public void shouldReuseGroupNameMappingFileWithIncrementalBuild() throws Exception {
assertEquals(2,victim.getTargetGroupsAsList().size());
groupNames.load(new FileInputStream(groupNameMappingFile));
assertEquals(4,groupNames.entrySet().size());
assertEquals(1,victim.getTargetGroupsAsList().size());
groupNames.load(new FileInputStream(groupNameMappingFile));
assertEquals(4,groupNames.entrySet().size());
}