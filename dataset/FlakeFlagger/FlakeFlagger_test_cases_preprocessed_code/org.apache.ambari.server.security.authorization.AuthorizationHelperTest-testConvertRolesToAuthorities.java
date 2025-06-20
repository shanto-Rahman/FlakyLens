@Test public void testConvertRolesToAuthorities() throws Exception {
assertEquals("Wrong number of authorities",2,authorities.size());
assertEquals("Wrong authority name","ADMIN",iterator.next().getAuthority());
}