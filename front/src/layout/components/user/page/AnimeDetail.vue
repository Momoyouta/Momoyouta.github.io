<template>
  <div class="divide"></div>
  <InfoCard class="info cp"></InfoCard>
  <AdCard class="ad cp"></AdCard>
  <VedioList class="vedio cp"></VedioList>
</template>

<script setup>

import InfoCard from "@/components/animedetail/InfoCard.vue";
import AdCard from "@/components/common/AdCard.vue";
import VedioList from "@/components/animedetail/VedioList.vue";
</script>

<style scoped>
.divide{
  width: 100%;
  height: 0.3rem;
  border-bottom: var(--input-base) solid 2px;
  margin-bottom: 0.5rem;
}
.cp{
  margin-bottom: 1rem;
}
</style>