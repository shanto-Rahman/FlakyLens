@Test public void testCloseEntityManagerFactory(){
assertTrue(entityManagerFactory.isOpen());
assertFalse(entityManagerFactory.isOpen());
}