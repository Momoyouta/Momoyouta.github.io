<template>
  <div class="main">
    <div class="banner-box" @mouseenter="pauseAutoPlay" @mouseleave="resumeAutoPlay">
      <ul class="banner" :style="bannerStyle">
        <li v-for="ani in aniList">
          <img :src="ani.image" alt="">
        </li>
      </ul>
    </div>
    <div class="container">
      <ul class="detail" :style="bannerStyle">
        <li v-for="(ani,index) in aniList" class="item">
          <div class="ani-name">{{ani.name}}</div>
          <div class="ani-text">
            <p class="ani-state">{{ani.state}}</p>
            <p class="ani-description"></p>{{ani.description}}
          </div>
        </li>

      </ul>
      <div class="slide-bullets">
        <ul class="bullets" >
          <li @click="changeBanner(n-1)" :class="{active:activeBanner==n-1}" v-for="n in aniList.length"></li>
        </ul>
      </div>
    </div>

  </div>
</template>

<script setup>


import {computed, onBeforeUnmount, onMounted, reactive, ref} from "vue";

const aniList=reactive([])
const activeBanner=ref(0)
const timer = ref(null)
const transitionEnabled = ref(true)
import img1url from "/assets/img/ani_banner_test.webp";
import img2url from "/assets/img/ani_banner_test2.webp";
const ani=reactive({
  id: 1,
  name: '青春之箱',
  state: '更新至第23集',
  image: img1url,
  description: '在《周刊少年JUMP》好评连载的三浦糀创作的人气漫画《青之箱》。作品描写了个性丰满的角色们各怀心绪投身于社团活动的样子...'
})
const ani2=reactive({
  id: 1,
  name: 'Ave Mujica',
  state: '更新至第12集',
  image: img2url,
  description: '作品描写了个性丰满的角色们各怀心绪投身于社团活动的样子...'
})
onMounted(()=>{
  aniList.push(ani2);
  aniList.push(ani);
  startAutoPlay()
})
onBeforeUnmount(() => {
  clearInterval(timer.value);
})

const bannerStyle=computed(()=>{
  const offset=-(activeBanner.value)*100
  return{
    transform:`translateX(${offset}%)`,
    transition: transitionEnabled.value ? 'transform 0.5s ease' : 'none'
  }
})
function changeBanner(index){
  transitionEnabled.value = true;
  activeBanner.value = index;
}
function startAutoPlay() {
  timer.value = setInterval(() => {
    transitionEnabled.value = true
    activeBanner.value = (activeBanner.value + 1) % aniList.length;
  }, 3000)
}

function pauseAutoPlay() {
  clearInterval(timer.value)
}
function resumeAutoPlay() {
  startAutoPlay()
}


</script>

<style scoped>
.main{
  width: 100%;
  position: relative;
  aspect-ratio: 180/50;
  border-radius: 1rem;
  border: #f8d8d8 solid 1px;
  overflow: hidden;
}
.banner-box{
  width: 100%;
  height: 100%;
  overflow: hidden;
}
.container{
  width: 14.5rem;

  position: absolute;
  top: 30%;
  right: 10%;
  overflow: hidden;
}
.detail{
  max-height: 10rem;
}
.ani-name{
  text-align: center;
  font-size: 1.5rem;
  margin-bottom: 1rem;
  color: white;
  text-shadow: 0 0 2px #2c2c2c;
}
.ani-text{
  font-size: 0.9rem;
  color: var(--banner-font);
  text-shadow: 0 0 2px #2c2c2c;
  text-overflow: ellipsis;
  overflow: hidden;
  margin-bottom: 1rem;
}
.ani-state{
  text-align: center;

  margin-bottom: 0.5rem;
}
ul{
  display: flex;
}
.slide-bullets{

}
.bullets li{
  width: 6%;
  height: 0.5rem;
  background: black;
  opacity: 0.7;
  border-radius: 0.5rem;
  margin-right: 2%;
  cursor: pointer;
  transition: all 0.3s;
}
.bullets li:first-child{
  margin-left: 29%;
}
.bullets li.active{
  background-color: var(--banner-active);
}
.banner{
  width: 100%;
  height: 100%;
  will-change: transform;
}
.banner li{
  width: 100%;
  height: 100%;
  flex-shrink: 0;
  transition: opacity 0.5s;
}
.banner li img{
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.detail li{
  width: 100%;
  height: 100%;
  flex-shrink: 0;
}
</style>