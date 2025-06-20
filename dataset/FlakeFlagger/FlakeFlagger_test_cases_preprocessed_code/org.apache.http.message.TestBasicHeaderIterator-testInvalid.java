@Test public void testInvalid(){
Assert.fail("null headers not detected");
Assert.assertFalse(hit.hasNext());
Assert.fail("next beyond end not detected");
}