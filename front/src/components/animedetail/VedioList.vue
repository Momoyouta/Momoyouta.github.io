<template>
  <div class="box">
    <h2>选集播放</h2>
    <div class="ul-box">
      <ul>
        <li v-for="(item,index) in items">
          {{item}}
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import {reactive} from "vue";

const items=reactive(['第一集','第二集','第三集','第四集','第五集','第六集','第七集','第八集'])

</script>

<style scoped>
h2{
  margin-bottom:1rem;
}

.ul-box{
  background:var(--side-bg);
  padding:0.7rem;
  border-radius:1rem;
}
ul{
  display: flex;
}
li{
  padding: 0.2rem 0.5rem;
  width: 13%;
  border: 1px solid #ccc;
  border-radius: 0.4rem;
  margin-bottom: 0.5rem;
  margin-right: 1.5%;
  background: var(--side-bg);
  cursor: pointer;
  line-height: 1.4rem;
  text-align: center;
}
li:nth-child(8n){
  margin-right: 0;
}

li:hover{
  background: var(--btn-login);
  color: #fff;
}
</style>