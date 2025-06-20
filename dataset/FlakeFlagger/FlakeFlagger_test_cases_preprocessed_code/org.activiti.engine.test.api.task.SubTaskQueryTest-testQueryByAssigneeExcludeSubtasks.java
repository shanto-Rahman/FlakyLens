/** 
 * test for task inclusion/exclusion when additional filter is specified (like assignee), no order.
 */
public void testQueryByAssigneeExcludeSubtasks() throws Exception {
assertEquals(7,query.count());
assertEquals(7,query.list().size());
assertEquals(2,query.count());
assertEquals(2,query.list().size());
assertEquals(0,query.count());
assertEquals(0,query.list().size());
assertNull(query.singleResult());
assertEquals(0,query.count());
assertEquals(0,query.list().size());
assertNull(query.singleResult());
}