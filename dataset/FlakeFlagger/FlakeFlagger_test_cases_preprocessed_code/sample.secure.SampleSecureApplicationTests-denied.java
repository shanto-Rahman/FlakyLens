@Test(expected=AccessDeniedException.class) public void denied() throws Exception {
assertEquals(this.service.denied(),"Goodbye World");
}