@Test(expected=IllegalArgumentException.class) public void emptyApplicationContext() throws Exception {
assertTrue(getOutput().contains(SPRING_STARTUP));
}