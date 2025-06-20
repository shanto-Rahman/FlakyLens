@Test public void testTokenChar(){
Assert.assertTrue("letter",bti.isTokenChar('j'));
Assert.assertFalse("control",bti.isTokenChar('\b'));
Assert.assertFalse("separator",bti.isTokenChar('?'));
Assert.assertTrue("other",bti.isTokenChar('-'));
}