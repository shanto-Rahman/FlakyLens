/** 
 * test for task inclusion/exclusion when additional filter is specified (like assignee), ordered.
 */
public void testQueryByAssigneeExcludeSubtasksOrdered() throws Exception {
assertEquals(7,query.count());
assertEquals(7,query.list().size());
assertEquals(sdf.parse("02/01/2009 01:01:01.000"),query.list().get(0).getCreateTime());
assertEquals(2,query.count());
assertEquals(2,query.list().size());
assertEquals(sdf.parse("01/02/2008 02:02:02.000"),query.list().get(0).getCreateTime());
assertEquals(sdf.parse("05/02/2008 02:02:02.000"),query.list().get(1).getCreateTime());
assertEquals(0,query.count());
assertEquals(0,query.list().size());
assertNull(query.singleResult());
assertEquals(0,query.count());
assertEquals(0,query.list().size());
assertNull(query.singleResult());
}