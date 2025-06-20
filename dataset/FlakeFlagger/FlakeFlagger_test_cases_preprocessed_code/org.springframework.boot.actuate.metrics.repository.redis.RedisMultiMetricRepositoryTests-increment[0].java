@Test public void increment(){
if (metric.getName().equals("foo.bar")) {
}
assertEquals(2,names.size());
assertTrue("Wrong names: " + names,names.contains("foo.bar"));
assertEquals(3d,bar.getValue());
}