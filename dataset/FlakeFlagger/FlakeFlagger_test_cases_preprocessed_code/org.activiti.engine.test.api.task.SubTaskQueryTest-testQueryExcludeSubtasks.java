/** 
 * test for task inclusion/exclusion (no other filters, no sort)
 */
public void testQueryExcludeSubtasks() throws Exception {
assertEquals(10,query.count());
assertEquals(10,query.list().size());
assertEquals(3,query.count());
assertEquals(3,query.list().size());
}