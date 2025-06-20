@Test public void testBucketHashGeneration(){
  ArrayList<String> fieldNames=new ArrayList<String>();
  fieldNames.add("d");
  fieldNames.add("ts");
  ArrayList<ObjectInspector> fieldObjectInspectors=new ArrayList<ObjectInspector>();
  fieldObjectInspectors.add(PrimitiveObjectInspectorFactory.javaDateObjectInspector);
  fieldObjectInspectors.add(PrimitiveObjectInspectorFactory.javaTimestampObjectInspector);
  fieldObjectInspectors.add(PrimitiveObjectInspectorFactory.javaTimestampObjectInspector);
  StandardStructObjectInspector soi1=ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames,fieldObjectInspectors);
  ArrayList<Object> struct=new ArrayList<Object>(2);
  struct.add(Date.of(1970,1,1));
  struct.add(Timestamp.valueOf("1969-12-31 16:00:00"));
  struct.add(Timestamp.valueOf("1970-01-01 00:00:00"));
  Object[] bucketFields=struct.toArray();
  ObjectInspector[] bucketFieldInspectors=fieldObjectInspectors.toArray(new ObjectInspector[fieldObjectInspectors.size()]);
  int fieldHash=ObjectInspectorUtils.hashCode(bucketFields[0],bucketFieldInspectors[0]);
  assertEquals("",0,fieldHash);
  fieldHash=ObjectInspectorUtils.hashCode(bucketFields[1],bucketFieldInspectors[1]);
  assertEquals("",0,fieldHash);
  fieldHash=ObjectInspectorUtils.hashCode(bucketFields[2],bucketFieldInspectors[2]);
  assertEquals("",7200,fieldHash);
}
