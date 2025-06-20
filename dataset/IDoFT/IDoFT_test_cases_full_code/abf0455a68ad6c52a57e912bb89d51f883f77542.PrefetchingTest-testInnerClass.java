public void testInnerClass() throws Exception {
  Echo<Object> e=new Echo<>();
  e.value=cl.loadClass("test.Foo").newInstance();
  Object r=channel.call(e);
  ((Predicate<Void>)r).apply(null);
}
