@Test public void testOps() throws Exception {
assertThat(stack.get(0),equalTo("one"));
assertThat(stack.peek(),equalTo("one"));
assertThat(stack.size(),equalTo(1));
assertThat(stack.get(0),equalTo("one"));
assertThat(stack.peek(),equalTo("two"));
assertThat(stack.size(),equalTo(2));
assertThat(stack.set(0,"three"),equalTo("one"));
assertThat(stack.remove(0),equalTo("three"));
assertThat(stack.size(),equalTo(1));
assertThat(stack.isEmpty(),is(false));
assertThat(stack.get(0),equalTo("two"));
assertThat(stack.peek(),equalTo("two"));
assertThat(stack.pop(),equalTo("two"));
assertThat(stack.isEmpty(),is(true));
}