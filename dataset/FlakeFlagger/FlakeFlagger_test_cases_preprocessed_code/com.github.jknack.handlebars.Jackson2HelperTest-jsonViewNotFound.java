@Test(expected=HandlebarsException.class) public void jsonViewNotFound() throws IOException {
assertEquals("{\"title\":\"First Post\"}",result);
}