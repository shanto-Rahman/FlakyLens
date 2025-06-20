@Test public void testToJSON(){
  Fuse root=new Fuse(0,32);
  Fuse f1=new Fuse(1,32);
  root.addChild(f1);
  ChargingStation cs1=buildDefaultChargingStation();
  f1.addChild(cs1);
  ChargingStation cs2=buildDefaultChargingStation();
  f1.addChild(cs2);
  Fuse f2=new Fuse(2,32);
  root.addChild(f2);
  FuseTree fuseTree=new FuseTree(root,20);
  JSONObject json1=fuseTree.toJSONObject();
  String jsonString1=json1.toString();
  FuseTree clone=FuseTree.fromJSON(json1,new ArrayList<ChargingStation>());
  String jsonString2=clone.toJSONObject().toString();
  assertEquals(jsonString1,jsonString2);
}
