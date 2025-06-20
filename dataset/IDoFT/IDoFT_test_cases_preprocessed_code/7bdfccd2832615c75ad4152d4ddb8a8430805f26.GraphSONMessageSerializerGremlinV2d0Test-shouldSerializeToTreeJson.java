@Test public void shouldSerializeToTreeJson() throws Exception {
assertEquals(1,deserializedTree.size());
assertEquals(1,v.id());
assertEquals("marko",v.property("name").value());
assertEquals(3,firstTree.size());
assertEquals(3,vp.id());
assertEquals("vadas",vp.value());
assertEquals(5,vp.id());
assertEquals("lop",vp.value());
assertEquals(7,vp.id());
assertEquals("josh",vp.value());
}