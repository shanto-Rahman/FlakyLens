@Test public void testBuildJSONNode(){
assertEquals(name,node.getString("name"));
assertEquals(2,node.getInt("group"));
assertNotNull(node.getString("description"));
assertEquals(sourcecode,node.getString("sourcecode"));
}