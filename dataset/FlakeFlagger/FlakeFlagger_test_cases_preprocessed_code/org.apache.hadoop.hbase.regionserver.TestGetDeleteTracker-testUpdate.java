public void testUpdate(){
assertEquals(dels1.size(),delList.size());
assertEquals(0,Bytes.compareTo(dels1.get(i).buffer,delList.get(i).buffer));
assertEquals(dels1.get(i).qualifierOffset,delList.get(i).qualifierOffset);
assertEquals(dels1.get(i).qualifierLength,delList.get(i).qualifierLength);
assertEquals(dels1.get(i).timestamp,delList.get(i).timestamp);
assertEquals(dels1.get(i).type,delList.get(i).type);
assertEquals(0,Bytes.compareTo(res.get(i).buffer,delList.get(i).buffer));
assertEquals(res.get(i).qualifierOffset,delList.get(i).qualifierOffset);
assertEquals(res.get(i).qualifierLength,delList.get(i).qualifierLength);
assertEquals(res.get(i).timestamp,delList.get(i).timestamp);
assertEquals(res.get(i).type,delList.get(i).type);
if (PRINT) {
}
}