@Test public void autoOnConsoleStatusListener() throws JoranException {
assertEquals(0,sll.size());
assertTrue(sll.size() + " should be 1",sll.size() == 1);
}