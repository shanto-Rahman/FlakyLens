/** 
 * Exercises the JSONObject.valueToString() method for various types
 */
@Test public void valueToString(){
  assertTrue("null valueToString() incorrect","null".equals(JSONObject.valueToString(null)));
  MyJsonString jsonString=new MyJsonString();
  assertTrue("jsonstring valueToString() incorrect","my string".equals(JSONObject.valueToString(jsonString)));
  assertTrue("boolean valueToString() incorrect","true".equals(JSONObject.valueToString(Boolean.TRUE)));
  assertTrue("non-numeric double","null".equals(JSONObject.doubleToString(Double.POSITIVE_INFINITY)));
  String jsonObjectStr="{" + "\"key1\":\"val1\"," + "\"key2\":\"val2\","+ "\"key3\":\"val3\""+ "}";
  JSONObject jsonObject=new JSONObject(jsonObjectStr);
  assertTrue("jsonObject valueToString() incorrect",JSONObject.valueToString(jsonObject).equals(jsonObject.toString()));
  String jsonArrayStr="[1,2,3]";
  JSONArray jsonArray=new JSONArray(jsonArrayStr);
  assertTrue("jsonArray valueToString() incorrect",JSONObject.valueToString(jsonArray).equals(jsonArray.toString()));
  Map<String,String> map=new HashMap<String,String>();
  map.put("key1","val1");
  map.put("key2","val2");
  map.put("key3","val3");
  assertTrue("map valueToString() incorrect",jsonObject.toString().equals(JSONObject.valueToString(map)));
  Collection<Integer> collection=new ArrayList<Integer>();
  collection.add(new Integer(1));
  collection.add(new Integer(2));
  collection.add(new Integer(3));
  assertTrue("collection valueToString() expected: " + jsonArray.toString() + " actual: "+ JSONObject.valueToString(collection),jsonArray.toString().equals(JSONObject.valueToString(collection)));
  Integer[] array={new Integer(1),new Integer(2),new Integer(3)};
  assertTrue("array valueToString() incorrect",jsonArray.toString().equals(JSONObject.valueToString(array)));
}
