@Test public void testSetAndGetTemplate(){
assertEquals("/my/custom/template.ftl.html",result.getTemplate());
assertEquals(Result.SC_200_OK,result.getStatusCode());
}