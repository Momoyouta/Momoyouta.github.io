<template>
  <div class="divide"></div>
  <AnimeSearchPage keyword="魔王"></AnimeSearchPage>
</template>

<script setup>

import AnimeDetail from "@/layout/components/user/page/AnimeDetailPage.vue";
import AnimeSearchPage from "@/layout/components/user/page/AnimeSearchPage.vue";
</script>

<style scoped>
.divide{
  width: 100%;
  height: 0.3rem;
  border-bottom: var(--input-base) solid 2px;
  margin-bottom: 0.5rem;
}
</style>