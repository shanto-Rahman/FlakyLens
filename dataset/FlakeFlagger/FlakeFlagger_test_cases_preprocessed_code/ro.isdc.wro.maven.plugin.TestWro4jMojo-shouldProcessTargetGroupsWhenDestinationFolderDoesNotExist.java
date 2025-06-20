/** 
 * Test for the following scenario: when incremental build is performed, only changed resources are processed. Given that there are two target groups, and a resource from only one group is changed incremental build should process only that one group. However, if the targetFolder does not exist, all target groups must be processed.
 */
@Test public void shouldProcessTargetGroupsWhenDestinationFolderDoesNotExist() throws Exception {
assertEquals(totalGroups,victim.getTargetGroupsAsList().size());
assertEquals(0,victim.getTargetGroupsAsList().size());
assertEquals(9,victim.getTargetGroupsAsList().size());
}