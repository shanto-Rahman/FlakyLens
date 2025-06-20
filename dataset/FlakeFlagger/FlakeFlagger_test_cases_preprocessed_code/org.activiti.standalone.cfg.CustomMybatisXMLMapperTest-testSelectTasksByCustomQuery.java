public void testSelectTasksByCustomQuery(){
assertEquals(5,tasks.size());
assertEquals(5,new CustomTaskQuery(managementService).unOwned().count());
}