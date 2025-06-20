@Test public void testPojoConversion(){
assertEquals(s,expected);
assertEquals(temp.getFoo(),"testFoo");
assertEquals(2,temp.getBan().size());
assertEquals(temp.getFoo(),"testFoo");
assertEquals(2,temp.getBan().size());
assertEquals(s,"<root><bar>1</bar><foo>testFoo</foo><baz/><ban><bar>0</bar><foo>p1</foo><baz/><ban/></ban><ban><bar>0</bar><foo>p2</foo><baz/><ban/></ban></root>");
}