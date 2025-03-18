<template>
 <AnimationCard class="test" :showCon="showCon" :ani="ani"></AnimationCard>
<!--  <AnimationCard style="width: 5rem; font-size: 10px"></AnimationCard>-->
</template>

<script setup>

import AnimationCard from "@/components/common/AnimationCard.vue";
const showCon={
  score: false,
  date: true,
  state: true,
  name: true
}

const ani={
  id: 1,
  name: "胆大党",
  score: "1.0",
  updateTime: "03/05",
  state: "更新至第9集",
  url: "https://www.huya.com/matongc",
  img: "/src/assets/img/ani_test.webp"
}

</script>

<style scoped>
.test{
  width: 10rem;
}

</style>