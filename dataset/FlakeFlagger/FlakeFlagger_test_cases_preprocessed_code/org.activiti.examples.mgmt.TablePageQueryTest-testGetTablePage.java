public void testGetTablePage(){
assertEquals(0,tablePage.getFirstResult());
assertEquals(5,tablePage.getSize());
assertEquals(5,tablePage.getRows().size());
assertEquals(20,tablePage.getTotal());
assertEquals(14,tablePage.getFirstResult());
assertEquals(6,tablePage.getSize());
assertEquals(6,tablePage.getRows().size());
assertEquals(20,tablePage.getTotal());
}