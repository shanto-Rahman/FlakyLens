@Test public void testNested(){
assertTrue(result.contains("+ INFO in " + this.getClass().getName()));
assertTrue(result.contains("+ WARN in " + this.getClass().getName()));
assertTrue(result.contains("    |-WARN in " + this.getClass().getName()));
}