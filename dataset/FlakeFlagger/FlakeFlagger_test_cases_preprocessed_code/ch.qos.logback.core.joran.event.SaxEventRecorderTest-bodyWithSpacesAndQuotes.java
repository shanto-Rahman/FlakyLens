@Test public void bodyWithSpacesAndQuotes() throws Exception {
assertEquals(3,seList.size());
assertEquals("[x][x] \"xyz\"%n",be.getText());
}