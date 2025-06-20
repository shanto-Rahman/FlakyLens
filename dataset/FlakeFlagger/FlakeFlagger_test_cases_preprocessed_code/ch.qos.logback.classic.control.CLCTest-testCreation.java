public void testCreation(){
assertEquals("x.y.z",xyz.getName());
assertEquals("x.y",xyz.parent.getName());
assertEquals("x",xyz.parent.parent.getName());
assertEquals("root",xyz.parent.parent.parent.getName());
assertEquals("x.y.z",xyz_.getName());
}