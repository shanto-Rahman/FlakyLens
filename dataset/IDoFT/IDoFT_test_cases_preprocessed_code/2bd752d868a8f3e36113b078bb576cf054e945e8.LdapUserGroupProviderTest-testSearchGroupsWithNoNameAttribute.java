@Test public void testSearchGroupsWithNoNameAttribute() throws Exception {
assertEquals(5,groups.size());
assertEquals(1,groups.stream().filter(group -> "cn=admins,ou=groups,o=nifi".equals(group.getName())).count());
}