@Test public void testApiAuthToken(){
Assert.assertEquals("TOKEN",apiDoc.getAuth().getType());
Assert.assertEquals("",apiDoc.getAuth().getScheme());
Assert.assertEquals("abc",apiDoc.getAuth().getTesttokens().iterator().next());
if (apiMethodDoc.getPath().contains("/inherit")) {
Assert.assertEquals("TOKEN",apiMethodDoc.getAuth().getType());
Assert.assertEquals("",apiMethodDoc.getAuth().getScheme());
Assert.assertEquals("abc",apiMethodDoc.getAuth().getTesttokens().iterator().next());
}
if (apiMethodDoc.getPath().contains("/override")) {
Assert.assertEquals("TOKEN",apiMethodDoc.getAuth().getType());
Assert.assertEquals("Bearer",apiMethodDoc.getAuth().getScheme());
Assert.assertEquals("xyz",apiMethodDoc.getAuth().getTesttokens().iterator().next());
}
}