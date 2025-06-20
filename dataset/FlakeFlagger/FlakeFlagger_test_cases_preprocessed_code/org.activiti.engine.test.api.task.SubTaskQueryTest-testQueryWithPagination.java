/** 
 * test for task inclusion/exclusion (no other filters, no sort)
 */
public void testQueryWithPagination() throws Exception {
assertEquals(10,query.count());
assertEquals(2,query.listPage(0,2).size());
assertEquals(3,query.count());
assertEquals(1,query.listPage(0,1).size());
}