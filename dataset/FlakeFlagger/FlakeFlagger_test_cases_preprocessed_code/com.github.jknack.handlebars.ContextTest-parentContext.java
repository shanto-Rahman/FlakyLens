@Test public void parentContext(){
assertNotNull(parent);
assertEquals("Handlebars",parent.get("name"));
assertEquals("Extended",child.get("n"));
assertEquals("Handlebars",child.get("name"));
}