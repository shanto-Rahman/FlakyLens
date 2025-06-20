@Test public void getBeans() throws ClassNotFoundException, IOException {
Assert.assertSame(beans.keySet(),this.group.getBeans());
}