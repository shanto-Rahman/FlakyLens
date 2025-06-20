@Test public void testDefaultHome(){
assertEquals(new File(System.getProperty("loader.home")),launcher.getHomeDirectory());//RO
}