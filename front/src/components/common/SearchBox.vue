<template>
  <div class="searchbox">
    <div class="input">
      <input type="text"  v-model="searchAniText" @keyup.enter.prevent="submit" class="inputtext" placeholder="请输入">
    </div>
    <div class="iconbox">
      <button class="btn" @click="submit" >
        <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-sousuo"></use>
        </svg>
      </button>
    </div>
  </div>

</template>

<script setup>

import {ref} from "vue";

const searchAniText=ref("");
const emit=defineEmits(['getSearch']);

function submit (){
  emit("getSearch",searchAniText.value);
}

</script>

<style scoped>
.searchbox{
  display: flex;
  height: 2.5rem;
  width: 100%;
  align-items: center;
  background-color: var(--input-base);

}
.input{
  flex:1;
  height: 100%;
}
.inputtext{
  height: 100%;
  width: 100%;
  border: none;
  outline: none;
  padding: 0 1.5rem;
  border-radius: 100%;
  background-color: var(--input-base);
}
.iconbox{
  width: 8%;
  height: 85%;
  display: flex;
  justify-content: center;
  align-items: center;
}
.btn{
  width: 95%;
  height: 80%;
  background: none;
  border: none;
  padding: 0;
  cursor: pointer;
}
.icon{
  width: 95%;
  height: 80%;
  color: #474646;
}
.inputtext{
  font-size: 1rem;
}
</style>