@Test public void testCreateEntityManager(){
assertNotNull(entityManager);
assertTrue(entityManagerFactory.isOpen());
}