<template>
  <div class="divide">
    <span class="head">动漫库</span>
  </div>
  <div class="tag-choose" v-for="(items,index) in tags" :key="index">
    <div class="tag-list-box">
      <div class="title">
        {{ titles[index] }}
        <span class="iconfont icon-you"></span>
      </div>
    </div>
    <TagList class="taglist-box" :isChoose="true" :items="items"></TagList>
  </div>
  <div class="aniList">
    <ul class="animes">
      <li class="anime" v-for="(ani,index) in aniList">
        <AnimationCard style="width: 100%;font-size: 16px" :ani="ani.data" :show-con="ani.show"></AnimationCard>
      </li>
    </ul>
  </div>
</template>

<script setup>

import TagList from "@/components/common/TagList.vue";
import AnimationCard from "@/components/common/AnimationCard.vue";
import {onMounted, onUnmounted, reactive, ref, watch} from "vue";
import axios from "axios";
import {AXIOS_URL} from "@/common/axios_url.js";
const titles=['类型','地区','年份','排序']
const tags=[['全部',"日常", "纯爱", "冒险", "科幻", "搞笑", "悬疑", "战斗", "奇幻", "校园",
  "治愈","日常", "纯爱", "冒险",'小说改',"科幻", "搞笑", "悬疑", "战斗", "奇幻", "校园", "治愈"],
['全部','日漫','国漫','美漫'],['全部',2022,2023,2024,2025],['时间排序','评分排序']]
let aniCount=1;
let isAll=0
const aniList=reactive([]);
const axios_instance=axios.create({
  baseURL: `${AXIOS_URL.BASIC}`,
})
onMounted(()=>{
  getData();
  aniCount=1;
  window.addEventListener("scroll",throttle(checkScroll))
});
onUnmounted(()=>{
  window.removeEventListener("scroll",throttle(checkScroll))
})
function getData(){
  axios_instance.get(`/admin${AXIOS_URL.SEARCH_ANI}/bynamelike`,{
    params:{
      name: '',
      page: aniCount,
      pageSize: 12,
    }
  })
      .then(res => {
        for(let item of res.data.data) {
          let anttp = {
            show: {
              score: false,
              date: false,
              state: true,
              name: true
            },
            data: {
              id: item.id,
              name: item.name,
              image: item.image,
              ep: item.ep,
              end: item.end,
              updateTime: item.updateTime,
            }
          }
          aniList.push(anttp);
        }
        if(res.data.data.length<12){
          isAll=1;
        }
      })
      .catch(err=>{console.log(err)})
}
function checkScroll(){
  const scrollTop=window.scrollY;
  const clientHeight=window.innerHeight;
  const scrollHeight =document.documentElement.scrollHeight;
  if(Math.ceil(scrollTop+clientHeight)>=scrollHeight&&isAll===0){
    aniCount++;
    getData();
  }
}
function throttle(fn,delay=200){
  let timer = null;
  return (...args)=>{
    if(!timer){
      timer=setTimeout(()=>{
        fn.apply(this,args);
        timer = null;
      },delay)
    }
  }
}

</script>

<style scoped>
.divide{
  width: 100%;
  border-bottom: var(--input-base) solid 3px;
  margin-bottom: 0.5rem;
  cursor: default;
}
.head{
  font-size: 2.5rem;
  font-weight: bold;
  padding-top: 0.5rem;
  border-bottom: var(--banner-active) solid 3px;

}
.tag-choose {
  width: 100%;
  display: flex;
  border-bottom: var(--input-base) solid 2px;
}
.tag-list-box {
  width: 7%;
  padding-top: 0.5rem;
}
.taglist-box{
  flex: 1;
  padding-top: 0.5rem;
}
.title{
  padding-top: 0.2rem;
  font-weight: bold;
}
.iconfont{
  color: var(--btn-login);
}

.aniList{
  margin-top: 1rem;
}
.animes{
  display: flex;
  flex-wrap: wrap;
}
.anime{
  width: 15%;
  margin-right: 2%;
  margin-bottom: 2%;
  box-sizing: border-box;
  cursor: pointer;
}

.anime:nth-child(6n){
  margin-right: 0;
}
</style>