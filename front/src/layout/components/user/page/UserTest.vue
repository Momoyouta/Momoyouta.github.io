<template>
  <div class="divide"></div>
  <AnimeDetail></AnimeDetail>
</template>

<script setup>

import AnimeDetail from "@/layout/components/user/page/AnimeDetail.vue";
</script>

<style scoped>
.divide{
  width: 100%;
  height: 0.3rem;
  border-bottom: var(--input-base) solid 2px;
  margin-bottom: 0.5rem;
}
</style>