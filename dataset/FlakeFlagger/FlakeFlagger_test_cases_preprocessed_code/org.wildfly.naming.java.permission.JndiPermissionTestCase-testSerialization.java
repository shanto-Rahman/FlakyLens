@Test public void testSerialization(){
assertEquals(jndiPermission,((SerializedJndiPermission)jndiPermission.writeReplace()).readResolve());
}