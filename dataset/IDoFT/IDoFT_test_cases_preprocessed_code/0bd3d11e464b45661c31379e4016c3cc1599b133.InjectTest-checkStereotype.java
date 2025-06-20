@Test @InSequence(11) public void checkStereotype() throws IOException {
String output=getResponse(new URL(indexUrl.toString() + "/" + StereotypePage.class.getSimpleName()),client);//RW
assertNotNull(output);
assertTrue("Injection of stereotyped bean failed in page StereotypePage",output.contains("Stereotype bean:true"));
assertTrue("Stereotype Bean not SessionScoped as expected in page StereotypePage",output.contains("Same instance:true"));
output=getResponse(indexUrl,client);//RW
output=getResponse(new URL(indexUrl.toString() + "/" + InvalidateSessionPage.class.getSimpleName()),client);//RW
assertNotNull(output);
output=getResponse(indexUrl,client);//RW
assertTrue("Stereotype Bean not SessionScoped as expected in page StereotypePage",output.contains("stereotype:false"));
}