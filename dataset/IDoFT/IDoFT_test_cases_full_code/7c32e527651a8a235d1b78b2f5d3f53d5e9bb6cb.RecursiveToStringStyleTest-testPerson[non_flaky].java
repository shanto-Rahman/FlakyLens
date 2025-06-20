@Test public void testPerson(){
  final Person p=new Person();
  p.name="John Doe";
  p.age=33;
  p.smoker=false;
  p.job=new Job();
  p.job.title="Manager";
  final String pBaseStr=p.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p));
  final String pJobStr=p.job.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(p.job));
  assertEquals(pBaseStr + "[age=33,job=" + pJobStr+ "[title=Manager],name=John Doe,smoker=false]",new ReflectionToStringBuilder(p,new RecursiveToStringStyle()).toString());
}
