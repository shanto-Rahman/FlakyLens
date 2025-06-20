@Test public void testReferencedGroupWithoutDefiningReferencedAttribute() throws Exception {
assertEquals(1,groups.size());
assertNotNull(team3);
assertTrue(team3.getUsers().isEmpty());
}