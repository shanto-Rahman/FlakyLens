/** 
 * Exercises the JSONObject.valueToString() method for various types
 */
@Test public void valueToString(){
assertTrue("null valueToString() incorrect","null".equals(JSONObject.valueToString(null)));
assertTrue("jsonstring valueToString() incorrect","my string".equals(JSONObject.valueToString(jsonString)));
assertTrue("boolean valueToString() incorrect","true".equals(JSONObject.valueToString(Boolean.TRUE)));
assertTrue("non-numeric double","null".equals(JSONObject.doubleToString(Double.POSITIVE_INFINITY)));
assertTrue("jsonObject valueToString() incorrect",JSONObject.valueToString(jsonObject).equals(jsonObject.toString()));
assertTrue("jsonArray valueToString() incorrect",JSONObject.valueToString(jsonArray).equals(jsonArray.toString()));
assertTrue("map valueToString() incorrect",jsonObject.toString().equals(JSONObject.valueToString(map)));
assertTrue("collection valueToString() expected: " + jsonArray.toString() + " actual: "+ JSONObject.valueToString(collection),jsonArray.toString().equals(JSONObject.valueToString(collection)));
assertTrue("array valueToString() incorrect",jsonArray.toString().equals(JSONObject.valueToString(array)));
}