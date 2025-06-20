@Test @Transactional public void test1(){
assertThat(count).isEqualTo(2);
assertThat(parentRepo.findById(new Parent.Key("S",1))).isNotNull();
assertThat(children.size()).isEqualTo(2);
assertThat(children.size()).isEqualTo(2);
assertThat(childRepo.findById(new Child.Key("S",1,2))).isNotNull();
assertArrayEquals(expected,parentRepo.getParentCodes().toArray());
}