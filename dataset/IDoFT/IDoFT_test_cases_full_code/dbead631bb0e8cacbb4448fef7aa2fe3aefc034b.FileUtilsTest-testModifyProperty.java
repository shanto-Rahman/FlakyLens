@Test public void testModifyProperty(){
  Map<String,String> map=new HashMap<String,String>();
  map.put("scheduler.email.from","xiaobao@from.com");
  map.put("scheduler.reliability.email.to","xiaobao@to.com");
  map.put("scheduler.pfdash.time","0 24/2 11 * * ?");
  map.put("newkey","newvalue");
  System.out.println(resourceFolder);
  File file=new File(resourceFolder,"application.properties");
  String unmodified=FileUtils.readFile(file);
  FileUtils.modifyPropertyFile(file,map);
  String modified=FileUtils.readFile(file);
  assertFalse(unmodified.equals(modified));
}
