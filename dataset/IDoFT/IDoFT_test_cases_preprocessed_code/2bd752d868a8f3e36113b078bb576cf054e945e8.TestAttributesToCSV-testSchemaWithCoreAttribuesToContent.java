@Test public void testSchemaWithCoreAttribuesToContent() throws Exception {
assertEquals(contentDataString.split(newline)[0],"beach-name,beach-location,path,filename,uuid");
assertEquals(contentDataString.split(newline)[1],"Malibu Beach,\"California, US\"," + path + ","+ filename+ ","+ uuid);
}