@Test public void testSchemaToContent() throws Exception {
assertEquals(contentDataString.split(newline)[0],"beach-name,beach-location");
assertEquals(contentDataString.split(newline)[1],"Malibu Beach,\"California, US\"");
}