@Test public void buildV1StoredIndex(){
  final String fieldName="testFiledName";
  V1StoredIndex index=new V1StoredIndex(fieldName);
  final Map<Integer,UnsignedByteArray> data=initData();
  List<UnsignedByteArray> elements=new ArrayList<>(data.size());
  for (  Map.Entry<Integer,UnsignedByteArray> entry : data.entrySet()) {
    index.addDocument(entry.getKey(),Collections.singletonList(entry.getValue()));
    elements.add(entry.getValue());
  }
  VariableLengthByteArrayIndexedList indexedList=new VariableLengthByteArrayIndexedList(elements);
  index.setDatabaseDocumentsCount(data.size());
  OutputStreamWritable outputStreamWritable=index.buildWritable();
  assert(outputStreamWritable.getSizeInBytes() == getSizeInBytes(fieldName,indexedList));
}
