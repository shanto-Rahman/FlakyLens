@Test public void testAbout() throws Exception {
Assert.assertNotNull(about);
Assert.assertEquals("Timeline Reader API",about.getAbout());
}