@Test public void testCollectionSerialization(){
assertNotNull(e=other.elements());
assertTrue(e.hasMoreElements());
assertEquals(new JndiPermission("foo/bar","createSubcontext,rebind"),e.nextElement());
assertTrue(e.hasMoreElements());
assertEquals(new JndiPermission("foo","addNamingListener"),e.nextElement());
assertTrue(e.hasMoreElements());
assertEquals(new JndiPermission("-","lookup,rebind"),e.nextElement());
assertFalse(e.hasMoreElements());
}