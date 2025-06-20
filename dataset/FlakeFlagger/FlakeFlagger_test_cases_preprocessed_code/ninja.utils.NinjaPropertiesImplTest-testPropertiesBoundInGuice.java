@Test public void testPropertiesBoundInGuice(){
assertNotNull("Application secret not set by Guice",service.applicationSecret);
assertEquals("secret",service.applicationSecret);
}