public void testSimpleSeqWrite() throws Exception {
assertTrue(it.hasNext());
assertEquals(a2q("{'id':1,'value':15}"),it.nextValue().toString());
assertTrue(it.hasNext());
assertEquals(a2q("{'id':2,'value':16}"),it.nextValue().toString());
assertTrue(it.hasNext());
assertEquals(a2q("{'id':3,'value':-999}"),it.nextValue().toString());
assertFalse(it.hasNext());
}