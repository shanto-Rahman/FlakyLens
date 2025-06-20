/** 
 * test for task inclusion/exclusion when additional filter is specified (like assignee), no order.
 */
public void testQueryByAssigneeExcludeSubtasksPaginated() throws Exception {
assertEquals(7,query.count());
assertEquals(2,query.listPage(0,2).size());
assertEquals(2,query.count());
assertEquals(1,query.listPage(0,1).size());
assertEquals(0,query.count());
assertEquals(0,query.listPage(0,2).size());
assertNull(query.singleResult());
assertEquals(0,query.count());
assertEquals(0,query.listPage(0,2).size());
assertNull(query.singleResult());
}