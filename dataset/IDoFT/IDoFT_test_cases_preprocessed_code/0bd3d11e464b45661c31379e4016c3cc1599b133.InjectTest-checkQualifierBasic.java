/** 
 * Todo - Add tests for session state. How  notify cdi about changes in session state objects ?
 */
@Test @InSequence(6) public void checkQualifierBasic() throws IOException {
String output=getResponse(new URL(indexUrl.toString() + "/" + DessertPage.class.getSimpleName()));//RW
assertTrue("Injection of pojo with qualifier failed in page Dessert",output.contains("dessert1:true"));
assertTrue("Injection of pojo with qualifier failed in page Dessert",output.contains("dessert2:true"));
assertTrue("Injection of pojo with qualifier and produces method failed in page Dessert",output.contains("dessert3:true"));
assertTrue("Injection of pojo with qualifier and produces method + @new failed in page Dessert",output.contains("dessert4:true"));
}