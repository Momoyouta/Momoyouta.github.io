<template>
  <div class="taglist-box">
    <ul>
      <li v-for="(item,index) in items" :class="{active:activeItem == index && isChoose}"
      @click="activeItem=index">{{item}}</li>
    </ul>
  </div>
</template>

<script setup>
import {reactive, ref} from "vue";
const activeItem=ref(0);
const props=defineProps({
  items:{
    type:Array,
    required:true
  },
  isChoose:{
    type:Boolean,
    default:false
  }
})
</script>

<style scoped>
.taglist-box{
  font-size: 100%;
}
ul{
  display: flex;
  flex-wrap: wrap;
}

li{
  padding: 0.2rem 0.5rem;
  border: 1px solid #ccc;
  border-radius: 0.4rem;
  margin-bottom: 0.5rem;
  margin-right: 0.5rem;
  background: var(--side-bg);
  cursor: pointer;
  line-height: 1.4rem;
}

li.active{
  background: var(--btn-login);
  color: #fff;
}

</style>