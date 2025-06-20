@Test public void regex() throws Exception {
assertEquals(this.sanitizer.sanitize("verylOCkish","secret"),"******");
assertEquals(this.sanitizer.sanitize("veryokish","secret"),"secret");
}