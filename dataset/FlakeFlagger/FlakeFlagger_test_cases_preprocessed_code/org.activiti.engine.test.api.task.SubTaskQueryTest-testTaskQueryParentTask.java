public void testTaskQueryParentTask() throws Exception {
assertEquals(2,query.count());
assertEquals(1,query.count());
assertEquals(0,query.count());
assertEquals(1,query.count());
}