@Test @InSequence(4) public void testAccess() throws Exception {
assertThat("Echoing Foo should return Foo not " + echo,echo,is("Foo"));
}