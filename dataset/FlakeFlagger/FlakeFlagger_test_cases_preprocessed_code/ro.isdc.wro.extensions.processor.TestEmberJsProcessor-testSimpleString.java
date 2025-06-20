@Test public void testSimpleString() throws Exception {
assertTrue(result.startsWith("(function() {Ember.TEMPLATES["));
assertTrue(result.contains("data.buffer.push(\"Hello {name}!\\n\");"));
}